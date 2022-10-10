package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Tires;
import com.berduchev.springprogectfirst.services.TireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
