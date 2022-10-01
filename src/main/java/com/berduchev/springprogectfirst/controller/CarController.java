package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Car> getAllCars(){
        Car car1 = new Car();
        car1.brend = "Audi";
        car1.quantity = 5;
        car1.fuel = "GasoLine";
        car1.model = "A5";
        carService.createCar(car1);
        return carService.getAllCars();
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
