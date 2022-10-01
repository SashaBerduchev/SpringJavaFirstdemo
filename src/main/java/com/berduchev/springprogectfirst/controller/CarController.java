package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String getAllCars(Model model){
        List<Car> cars = carService.getAllCars();
        Car car = cars.get(1);
        model.addAttribute("text", car.brend);
        System.out.println(this);
        return "cars";
    }

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carService.deleteCarById(id);
    }
}
