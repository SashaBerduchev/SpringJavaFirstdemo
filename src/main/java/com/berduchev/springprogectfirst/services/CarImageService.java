package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.CarImage;

import java.util.List;

public interface CarImageService {
    List<CarImage> getCarImages();
    CarImage getCarImageById(Long id);
    CarImage saveImage(CarImage image);
    void deleteCarImgById(Long id);
}
