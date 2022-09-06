/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/tour-stats")
    public String tourStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("tourStats", this.statsService.tourStats(kw, fromDate, toDate));
        return "tour-stats";
    }

    @GetMapping("/tour-month-stats")
    public String tourMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("tourMonthStats", this.statsService.tourMonthStats(kw, fromDate, toDate));
        return "tour-month-stats";
    }

    @GetMapping("/tour-quarter-stats")
    public String stats(Model model,
            @RequestParam(value = "quarter",defaultValue = "0" ) int quarter,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("tourQuarterStats", this.statsService.tourQuarterStats(quarter, year));
        return "tour-quarter-stats";
    }
}
