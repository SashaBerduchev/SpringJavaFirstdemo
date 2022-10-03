package com.berduchev.springprogectfirst.controller;

import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.model.Manager;
import com.berduchev.springprogectfirst.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("managers")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/all")
    public String getAllManagers(@RequestParam(name="manager", required=false, defaultValue="World") String manager, Model model){
        try {
            System.out.println(this);
            List<Manager> managers = managerService.getAllManager();
            model.addAttribute("managers", managers);
            System.out.println(this);
            System.out.println(managers);
            return "/managers/managers";
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
