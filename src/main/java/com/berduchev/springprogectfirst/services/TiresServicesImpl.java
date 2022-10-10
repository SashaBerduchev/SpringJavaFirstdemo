package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Tires;
import com.berduchev.springprogectfirst.repository.TiresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiresServicesImpl implements TireService{

    private TiresRepository tiresRepository;

    @Autowired
    public TiresServicesImpl(TiresRepository tiresRepository) {
        this.tiresRepository = tiresRepository;
    }


    @Override
    public List<Tires> getAllTires() {
        return tiresRepository.findAll();
    }

    @Override
    public Tires getTiresById(Long id) {
        return null;
    }

    @Override
    public void createTires(Tires tires) {
         tiresRepository.save(tires);
    }

    @Override
    public void deleteById(Long id) {
        tiresRepository.deleteById(id);
    }
}
