/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.pojo.Booking;
import com.tkv.pojo.Tour;
import com.tkv.pojo.Users;
import com.tkv.service.BookingService;
import com.tkv.service.TourService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private TourService tourService ;

    @GetMapping(value = "/booking/{tourid}")
    public String list(Model model,@PathVariable(value = "tourid") int tourid) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("tour", this.tourService.getTourById(tourid));
       
        return "booking";
    }

    @PostMapping("/booking/{tourid}")
    public String addBooking(@ModelAttribute(value = "booking") @Valid Booking booking,
            BindingResult result,
            @PathVariable(value = "tourid") int tourid,
            HttpServletRequest request,
            HttpSession session) {
        
        if (result.hasErrors()) {
            return "tourdetail";
        }
        Users u = (Users) session.getAttribute("currentUser");

        if (!result.hasErrors()) {
            if (u != null) {
                if (this.bookingService.addBooking(booking, u, tourid) == true) {
                    return "redirect:/";
                } else {
                    return "booking";
                }
            }
        }
        return "booking";
    }
}
