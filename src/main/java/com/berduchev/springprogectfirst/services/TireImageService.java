package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.TiresImages;

import java.util.List;

public interface TireImageService {
    List<TiresImages> getAllTireImages();
    TiresImages getImageBuId(Long id);
    void creaeImage(TiresImages images);
    void deleteImageById(Long id);

}
