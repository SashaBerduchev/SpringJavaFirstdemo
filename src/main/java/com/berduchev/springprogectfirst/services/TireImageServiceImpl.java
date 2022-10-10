package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Tires;
import com.berduchev.springprogectfirst.model.TiresImages;
import com.berduchev.springprogectfirst.repository.TiresImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TireImageServiceImpl implements TireImageService{

    private final TiresImagesRepository tiresImagesRepository;

    @Autowired
    public TireImageServiceImpl(TiresImagesRepository tiresImagesRepository) {
        this.tiresImagesRepository = tiresImagesRepository;
    }


    @Override
    public List<TiresImages> getAllTireImages() {
        return tiresImagesRepository.findAll();
    }

    @Override
    public TiresImages getImageBuId(Long id) {
        return null;
    }

    @Override
    public void creaeImage(TiresImages images) {
        tiresImagesRepository.save(images);
    }

    @Override
    public void deleteImageById(Long id) {
        tiresImagesRepository.deleteById(id);
    }
}
