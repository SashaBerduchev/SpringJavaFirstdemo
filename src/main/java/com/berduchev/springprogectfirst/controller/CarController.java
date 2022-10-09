package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("car")
public class CarController {

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






    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carService.deleteCarById(id);
    }
}
