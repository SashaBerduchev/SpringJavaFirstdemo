package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Tires;

import java.util.List;


public interface TireService {
    List<Tires> getAllTires();
    Tires getTiresById(Long id);
    void createTires(Tires tires);
    void deleteById(Long id);
}
