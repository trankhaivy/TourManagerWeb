/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.cloudinary.Cloudinary;
import com.tkv.pojo.Tour;
import com.tkv.service.TourService;
import com.tkv.service.TourtypesService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class TourController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private TourService tourService;

    @Autowired
    private TourtypesService tourtypesService;

    @GetMapping(value = "/admin/tours")
    public String list(Model model) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("price", tourService.getTours());
        model.addAttribute("tourtypes", tourtypesService.getTourtypes());
        return "tour";
    }

    @PostMapping("/admin/tours")
    public String addTour(Model model, @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {// bug in here
//            model.addAttribute("price", tourService.getTours());
            return "tour";
        }
        if (!result.hasErrors()) {
            if (tour.getTourname() != null && !tour.getTourname().isEmpty()) {
                if (this.tourService.addTour(tour) == true) {
                    return "redirect:/";
                } else {
                    model.addAttribute("price", tourService.getTours());
                    return "tour";
                }
            }
        }
        return "tour";
    }

    @RequestMapping("/admin/tours/delete/{tourid}")
    public String delTour(@PathVariable("tourid") int tourid,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result) {
        if (tour.getBookingList()==null) {
            tourService.delTour(tourid);
        }else{
            return "/";
        }
        return "redirect:/admin/tours";
    }

    @GetMapping("/admin/tours/update/{tourid}")
    public String tour(Model model, @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result,
            @PathVariable("tourid") int tourid) {
        model.addAttribute("tour", this.tourService.getTourById(tourid));
        model.addAttribute("tourtypes", tourtypesService.getTourtypes());
        return "updatetour";
    }

    @PostMapping("/admin/tours/update/{tourid}")
    public String updateTour(Model model, @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result,
            @PathVariable("tourid") int tourid) {
        if (!result.hasErrors()) {
//            if (tour.getTourname() != null && !tour.getTourname().isEmpty()) {
            if (this.tourService.updateTour(tour) == true) {
                return "redirect:/";
            } else {
                return "tour";
            }
        }
//        }
        return "updatetour";
    }
}
