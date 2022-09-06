/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.tkv.pojo.Rates;
import com.tkv.pojo.Tour;
import com.tkv.pojo.Users;
import com.tkv.repository.RateRepository;
import com.tkv.repository.TourRepository;
import com.tkv.repository.UserRepository;
import com.tkv.service.RateService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private TourRepository tourRepository ;
    
    @Autowired
    private UserRepository userRepository ;
    
    @Autowired
    private RateRepository rateRepository;
    
    @Override
    public Rates addRates(String comment, int tourid,Users creator) {
        Tour t = this.tourRepository.getTourById(tourid);
        
        Rates r = new Rates();
        r.setComment(comment);
        r.setTour(t);
        r.setUsers(creator);
        r.setRatingdate(new Date());
        return this.rateRepository.addRates(r);
    }
    
}
