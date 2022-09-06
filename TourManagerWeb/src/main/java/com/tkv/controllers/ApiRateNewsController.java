/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.pojo.Rates;
import com.tkv.pojo.Ratesofnews;
import com.tkv.pojo.Users;
import com.tkv.service.RateofnewsService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiRateNewsController {
    @Autowired
    private RateofnewsService rateofnewsService;

    @PostMapping(path = "/api/add-ratenews", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Ratesofnews> addRateNews(@RequestBody Map<String, String> params,
            HttpSession session) {
        Users u = (Users) session.getAttribute("currentUser");
        if (u != null)
            try {
            String comment = params.get("comment");
            int newsid = Integer.parseInt(params.get("newsid"));
            Ratesofnews ratesofnews = this.rateofnewsService.addRates(comment, newsid, u);

            return new ResponseEntity<>(ratesofnews, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
