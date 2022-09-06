/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.pojo.Users;
import com.tkv.service.BookingService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class BookingDetailController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/bookingdetail")
    public String list(Model model,HttpSession session) {
        Users u = (Users) session.getAttribute("currentUser");
        model.addAttribute("totalprice", this.bookingService.totalPrice(u.getUserid()));
        return "bookingdetail";
    }
    
    @RequestMapping("/bookingdetail/delete/{bookingid}")
    public String delTour(@PathVariable("bookingid") int bookingid){
        bookingService.delBooking(bookingid);
        return "redirect:/";
    }

}
