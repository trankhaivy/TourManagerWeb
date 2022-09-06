/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tkv.repository;

import com.tkv.pojo.Booking;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BookingRepository {
    boolean addBooking(Booking booking);
    List<Object[]> totalPrice(int userid);
    boolean delBooking(int id);
}
