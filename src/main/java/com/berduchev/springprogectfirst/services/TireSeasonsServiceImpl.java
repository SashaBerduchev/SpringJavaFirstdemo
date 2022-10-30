package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.TiresSeasons;
import com.berduchev.springprogectfirst.repository.TiresSeasonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TireSeasonsServiceImpl implements TireSeasonsService{

    private TiresSeasonsRepository tiresSeasonsRepository;
    @Autowired
    public TireSeasonsServiceImpl(TiresSeasonsRepository tiresSeasonsRepository) {
        this.tiresSeasonsRepository = tiresSeasonsRepository;
    }

    @Override
    public List<TiresSeasons> getTireSeasons() {
        return null;
    }

    @Override
    public void createTireSeasons(TiresSeasons tiresSeasons) {

    }
}
