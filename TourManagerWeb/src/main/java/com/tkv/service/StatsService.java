/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tkv.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsService {
    List<Object[]> tourStats(String kw, Date fromDate, Date toDate);
    List<Object[]> tourMonthStats(String kw, Date fromDate, Date toDate);
    List<Object[]> tourQuarterStats(int quarter, int y);
}
