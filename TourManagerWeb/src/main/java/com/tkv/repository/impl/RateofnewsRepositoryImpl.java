/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Ratesofnews;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tkv.repository.RateofnewsRepository;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class RateofnewsRepositoryImpl implements RateofnewsRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Ratesofnews addRates(Ratesofnews r) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(r);
            return r;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
