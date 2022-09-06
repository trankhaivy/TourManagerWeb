    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service;

import com.tkv.pojo.Tourtypes;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourtypesService {
    List<Tourtypes> getTourtypes();
    Tourtypes getTourtypesByTourId(int tourid);
}
