/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.tkv.pojo.Tourtypes;
import com.tkv.repository.TourtypesRepository;
import com.tkv.service.TourtypesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TourtypesServiceImpl implements TourtypesService{
    @Autowired
    private TourtypesRepository tourtypesRepository;
    @Override
    public List<Tourtypes> getTourtypes() {
        return this.tourtypesRepository.getTourtypes();
    }

    @Override
    public Tourtypes getTourtypesByTourId(int tourid) {
       return this.tourtypesRepository.getTourtypesByTourId(tourid);
    }
    
}
