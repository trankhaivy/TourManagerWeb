/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.tkv.pojo.News;
import com.tkv.pojo.Rates;
import com.tkv.pojo.Ratesofnews;
import com.tkv.pojo.Tour;
import com.tkv.pojo.Users;
import com.tkv.repository.NewsRepository;
import com.tkv.service.RateofnewsService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tkv.repository.RateofnewsRepository;

/**
 *
 * @author Admin
 */
@Service
public class RateofnewsServiceImpl implements RateofnewsService{

    @Autowired
    private NewsRepository newsRepository ;
    
    @Autowired
    private RateofnewsRepository ratesofnewsRepository ;
    
    @Override
    public Ratesofnews addRates(String content, int newsid, Users creator) {
        News n = this.newsRepository.getNewsById(newsid);
        
        Ratesofnews r = new Ratesofnews();
        r.setComment(content);
        r.setNews(n);
        r.setUsers(creator);
        r.setRatingdate(new Date());
        return this.ratesofnewsRepository.addRates(r);
    }
    
}
