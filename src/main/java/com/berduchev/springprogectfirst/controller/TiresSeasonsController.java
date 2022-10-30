package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.services.TireSeasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seasons")
public class TiresSeasonsController {

    private TireSeasonsService tireSeasonsService;

    @Autowired
    public TiresSeasonsController(TireSeasonsService tireSeasonsService) {
        this.tireSeasonsService = tireSeasonsService;
    }
}
