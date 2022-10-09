package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.CarImage;
import com.berduchev.springprogectfirst.services.CarImageService;
import com.berduchev.springprogectfirst.services.CarService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequestMapping("carimg")
public class CarImageController {

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


    private final CarImageService carImageService;

    @Autowired
    public CarImageController(CarImageService carImageService){this.carImageService = carImageService;}

    @GetMapping("/getimg")
    public void getImg(@RequestParam("id") Long id, Model model) throws UnsupportedEncodingException {
        CarImage carimg = carImageService.getCarImageById(id);
        System.out.println(carimg);
        Base64 item  = new Base64();
        byte[] encodeBase64 = item.encode(carimg.carimg);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        model.addAttribute("image", base64Encoded );
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam(name = "carbrend") String brend, @RequestParam(name = "carmodel") String modelcar, @RequestParam("file") MultipartFile file, Model model) {
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
            CarImage image = new CarImage();
            image.nameCar = brend;
            image.modelCar = modelcar;
            image.carimg = filestring;
            image.imgtype = file.getContentType();
            carImageService.saveImage(image);
            return  "progresses/excellent";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("text", e.getMessage());
            return  "progresses/error";
        }
    }
}
