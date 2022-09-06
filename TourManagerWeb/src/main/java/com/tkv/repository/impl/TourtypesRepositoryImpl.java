/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Tourtypes;
import com.tkv.repository.TourtypesRepository;
import java.util.List;
import javax.persistence.Query;
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
public class TourtypesRepositoryImpl implements TourtypesRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tourtypes> getTourtypes() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Tourtypes");
        return q.getResultList();
    }

    @Override
    public Tourtypes getTourtypesByTourId(int tourid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Tourtypes.class, tourid);
    }

}
