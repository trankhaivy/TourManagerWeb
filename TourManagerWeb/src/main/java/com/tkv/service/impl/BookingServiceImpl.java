/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.cloudinary.utils.ObjectUtils;
import com.tkv.pojo.Booking;
import com.tkv.pojo.Tour;
import com.tkv.pojo.Users;
import com.tkv.repository.BookingRepository;
import com.tkv.repository.TourRepository;
import com.tkv.service.BookingService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TourRepository tourRepository;

    @Override
    public boolean addBooking(Booking b, Users u, int tourid) {
        try {
            Tour t = this.tourRepository.getTourById(tourid);

            b.setUsers(u);
            b.setTour(t);
            return this.bookingRepository.addBooking(b);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<Object[]> totalPrice(int userid) {
        return this.bookingRepository.totalPrice(userid);
    }

    @Override
    public boolean delBooking(int id) {
        return this.bookingRepository.delBooking(id);
    }

   

}
