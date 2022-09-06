/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository;

import com.tkv.pojo.Tour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TourRepository {
    List<Tour> getTours(Map<String,String> params, int page);
    int countTour();
    List<Tour> getTours();
    Tour getTourById(int tourid);
    boolean addTour(Tour tour);
    List<Object[]> getHotTours(int num);
    boolean delTour(int id);
    boolean updateTour(Tour tour);
}
