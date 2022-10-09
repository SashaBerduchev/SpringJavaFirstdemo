package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.CarImage;
import com.berduchev.springprogectfirst.repository.CarImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImageServiceImpl implements CarImageService{

    private final CarImageRepository carImageRepository;

    @Autowired
    public CarImageServiceImpl(CarImageRepository carImageRepository) {
        this.carImageRepository = carImageRepository;
    }

    @Override
    public List<CarImage> getCarImages() {
        return carImageRepository.findAll();
    }

    @Override
    public CarImage getCarImageById(Long id) {
        return carImageRepository.getReferenceById(id);
    }

    @Override
    public CarImage saveImage(CarImage image) {
        return carImageRepository.save(image);
    }

    @Override
    public void deleteCarImgById(Long id) {
        carImageRepository.deleteById(id);
    }
}
