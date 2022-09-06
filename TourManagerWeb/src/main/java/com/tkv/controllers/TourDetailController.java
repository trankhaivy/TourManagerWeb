/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Admin
 */
@Controller
public class TourDetailController {
    @Autowired
    private TourService tourService;
    
    @GetMapping("/tour/{tourid}")
    public String detail(Model model,@PathVariable(value = "tourid") int tourid){
        model.addAttribute("tour",this.tourService.getTourById(tourid));
        return "tourdetail";
    }
}
