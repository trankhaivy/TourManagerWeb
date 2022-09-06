/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.tkv.repository.StatsRepository;
import com.tkv.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository ;
    @Override
    public List<Object[]> tourStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.tourStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> tourMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.tourMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> tourQuarterStats(int quarter, int y) {
        return this.statsRepository.tourQuarterStats(quarter, y);
    }
    
}
