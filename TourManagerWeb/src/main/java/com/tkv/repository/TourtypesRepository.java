/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository;

import com.tkv.pojo.Tourtypes;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourtypesRepository {
    List<Tourtypes> getTourtypes();
    Tourtypes getTourtypesByTourId(int tourid);
}
