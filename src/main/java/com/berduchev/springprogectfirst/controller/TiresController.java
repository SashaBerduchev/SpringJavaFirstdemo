package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Tires;
import com.berduchev.springprogectfirst.services.TireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("tires")
public class TiresController {
    private final TireService tireService;

    public TiresController(TireService tireService) {
        this.tireService = tireService;
    }
    @GetMapping("/all")
    public String getAllTires(Model model){
        List<Tires> tires = tireService.getAllTires();
        model.addAttribute("tires", tires);
        return "tires/index";
    }

    @GetMapping("/create")
    public String getTireCreate(){
        return "tires/addtire";
    }
    @GetMapping("/creative")
    public String setTire(@RequestParam(name = "Name") String name,
                          @RequestParam(name = "width") String width,
                          @RequestParam(name = "height") String height,
                          @RequestParam(name = "radius") String radius,
                          @RequestParam(name = "Seasons") String season,
                          @RequestParam(name = "TypeOfTire") String TypeOfTire, Model model){


        Tires tires = new Tires();
        tires.setName(name);
        tires.setTypeOfTire(TypeOfTire);
        tires.setRadius(radius);
        tires.setSeasons(season);
        tires.setHeight(Float.parseFloat(height));
        tires.setWidth(Float.parseFloat(width));
        tireService.createTires(tires);

        return "tires/index";
    }
}
