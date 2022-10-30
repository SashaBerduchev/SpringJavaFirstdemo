package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.TiresSeasons;

import java.util.List;

public interface TireSeasonsService {
    List<TiresSeasons> getTireSeasons();
    void createTireSeasons(TiresSeasons tiresSeasons);
}
