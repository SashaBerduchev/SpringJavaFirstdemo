package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.CarService;
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
            String brends = "";
            for(Integer i=0; i<cars.size(); i++){
                brends += cars.get(i).brend + " ";
            }
            model.addAttribute("brend", brends);
            System.out.println(brends);
            System.out.println(this);
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
    public String createCar(@RequestBody Car car, Model model){
        System.out.println(car);
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

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carService.deleteCarById(id);
    }
}
