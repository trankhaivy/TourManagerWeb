/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Rates;
import com.tkv.repository.RateRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class RateRepositoryImpl implements RateRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Rates addRates(Rates r) {
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
