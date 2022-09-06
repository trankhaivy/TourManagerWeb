/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tkv.service;

import com.tkv.pojo.Rates;
import com.tkv.pojo.Users;

/**
 *
 * @author Admin
 */
public interface RateService {
    Rates addRates(String content , int tourid, Users creator);
}
