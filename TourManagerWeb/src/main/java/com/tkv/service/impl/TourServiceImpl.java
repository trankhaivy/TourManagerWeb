/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tkv.pojo.Tour;
import com.tkv.repository.TourRepository;
import com.tkv.service.TourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        return this.tourRepository.getTours(params, page);
    }

    @Override
    public int countTour() {
        return this.tourRepository.countTour();
    }

    @Override
    public List<Tour> getTours() {
        return this.tourRepository.getTours();
    }

    @Override
    public boolean addTour(Tour tour) {
        try {
            Map results = this.cloudinary.uploader().upload(tour.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            tour.setImage((String) results.get("secure_url"));
            return this.tourRepository.addTour(tour);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Tour getTourById(int tourid) {
        return this.tourRepository.getTourById(tourid);
    }

    @Override
    public List<Object[]> getHotTours(int num) {
        return this.tourRepository.getHotTours(num);
    }

    @Override
    public Boolean delTour(int id) {
        return this.tourRepository.delTour(id);
    }

    @Override
    public boolean updateTour(Tour tour) {
         try {
            Map results = this.cloudinary.uploader().upload(tour.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            tour.setImage((String) results.get("secure_url"));
            return this.tourRepository.updateTour(tour);
        } catch (Exception ex) {
            return false;
        }
    }

}
