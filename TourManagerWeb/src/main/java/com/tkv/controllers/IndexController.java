/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;


import com.tkv.service.TourService;
import com.tkv.service.TourtypesService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private TourService tourService;

    @Autowired
    private TourtypesService tourtypesService;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        model.addAttribute("tourtypes", this.tourtypesService.getTourtypes());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
       
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("tours", this.tourService.getTours(params, page));
        model.addAttribute("counter", this.tourService.countTour());
        model.addAttribute("hotTours", this.tourService.getHotTours(4));
        return "index";
    }
}
