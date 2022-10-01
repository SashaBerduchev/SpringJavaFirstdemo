package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car createCar(Car car);
    void deleteCarById(Long id);
}
