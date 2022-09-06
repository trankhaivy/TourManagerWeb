/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service;

import com.tkv.pojo.Booking;
import com.tkv.pojo.Users;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BookingService {
    boolean addBooking(Booking b,Users u,int tourid);
    List<Object[]> totalPrice(int userid);
    boolean delBooking(int id);
}
