/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service;

import com.tkv.pojo.Tour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TourService {
    List<Tour> getTours(Map<String,String> params, int page);
    int countTour(); 
    List<Tour> getTours();
    boolean addTour(Tour tour);
    Tour getTourById(int tourid);
    List<Object[]> getHotTours(int num);
    Boolean delTour(int id);
    boolean updateTour(Tour tour);
}
