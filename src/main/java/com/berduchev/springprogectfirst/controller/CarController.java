package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.CarService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("car")
public class CarController {

    private String post;
    // Получить локальный IP
    private String host;
    // Корневой путь к хранилищу изображений
    private String rootPath = "D:";
    // Картинка хранится в подкаталоге в корневом каталоге
    private String sonPath = "/img/";
    // Получить ссылку на изображение
    private String imgPath;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String getAllCars(@RequestParam(name="brend", required=false, defaultValue="World") String brend, Model model){
        try {

            List<Car> cars = carService.getAllCars();
            model.addAttribute("cars", cars);
            System.out.println(this);
            System.out.println(cars);
            return "cars/cars";
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @GetMapping("/getimg")
    public void getImg(@RequestParam("id") Long id, Model model) throws UnsupportedEncodingException {
        Car car = carService.getCarById(id);
        System.out.println(car);
        Base64 item  = new Base64();
        byte[] encodeBase64 = item.encode(car.carimg);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        model.addAttribute("image", base64Encoded );
    }
    @GetMapping("/create")
    public String create(){
        System.out.println(this);
        return "cars/addcars";
    }
    @PostMapping("/createcar")
    public String createCar(@RequestParam(value = "brend", defaultValue = "Ford")String brend,
                            @RequestParam(value = "model", defaultValue = "Siera")String modelcar,
                            @RequestParam(value = "fuel", defaultValue = "Siera")String fuel,
                            @RequestParam(value = "quantity", defaultValue = "Siera")String quantity,Model model){
        System.out.println(brend);
        System.out.println(modelcar);
        Car car = new Car();
        car.brend = brend;
        car.fuel = fuel;
        car.model = modelcar;
        car.quantity = Integer.parseInt(quantity);
        Car carsave =  carService.createCar(car);
        System.out.println(carsave);
        List<Car> cars = carService.getAllCars();
        String brends = "";
        for(Integer i=0; i<cars.size(); i++){
            brends += cars.get(i).brend + " ";
        }
        model.addAttribute("brend", brends);
        System.out.println(brends);
        System.out.println(this);
        return "cars/cars";

    }

    @GetMapping("/addimage")
    public String addimage( Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "/cars/addimage";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam(name = "carbrend") String brend, @RequestParam("file") MultipartFile file, Model model) {
        // Возвращаем, является ли загруженный файл пустым, то есть файл не выбран или выбранный файл не имеет содержимого.
        // Предотвращение загрузки пустых файлов, чтобы вызвать сбой
        if (file.isEmpty()) {
            return "Файл пуст";
        }

        // Получить локальный IP
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("get server host Exception e:", e);
        }

        // Получить имя файла
        String fileName = file.getOriginalFilename();
        //logger.info("Имя загруженного файла: "+ имя_файла);
        // Установить путь после загрузки файла
        String filePath = rootPath + sonPath;
        logger.info ("Путь к загружаемому файлу" + filePath);
        logger.info ("Весь путь к изображению:" + host + ":" + post + sonPath + fileName);


        try {
            byte[] filestring = file.getBytes();
            List<Car> cars = carService.getAllCars();
            Car car = new Car();
            for(int i = 0; i < cars.size(); i++){
                if(Objects.equals(cars.get(i).getBrend(), brend)){
                    car = cars.get(i);
                }
            }
            if(car != null){
                Car newcar = new Car();
                newcar.brend = brend;
                newcar.model = car.model;
                newcar.fuel = car.fuel;
                newcar.quantity = car.quantity;
                newcar.carimg = filestring;
                newcar.imgtype = file.getContentType();
                carService.saveimg(newcar);
                return  "Загрузка успешна";
            }

            return "Нет машини!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  "/error: " + e.getMessage();
        }
    }




    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carService.deleteCarById(id);
    }
}
