/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.pojo.Rates;
import com.tkv.pojo.Users;
import com.tkv.service.RateService;
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
public class ApiRateController {

    @Autowired
    private RateService rateService;

    @PostMapping(path = "/api/add-rate", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Rates> addRate(@RequestBody Map<String, String> params,
            HttpSession session) {
        Users u = (Users) session.getAttribute("currentUser");
        if (u != null)
            try {
            String comment = params.get("comment");
            int tourid = Integer.parseInt(params.get("tourid"));
            Rates r = this.rateService.addRates(comment, tourid, u);

            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
