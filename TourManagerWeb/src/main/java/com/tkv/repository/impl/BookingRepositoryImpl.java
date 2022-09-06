/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Booking;
import com.tkv.pojo.Tour;
import com.tkv.pojo.Users;
import com.tkv.repository.BookingRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addBooking(Booking booking) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(booking);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object[]> totalPrice(int userid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);
        Root rootU = q.from(Users.class);

        q.where(builder.equal(rootT.get("tourid"), rootB.get("tour")),
                builder.equal(rootB.get("users"), rootU.get("userid")),
                builder.equal(rootU.get("userid"), userid));

        q.multiselect(rootT.get("image"), rootT.get("tourname"), rootT.get("priceforadult"),
                rootT.get("priceforchild"), rootB.get("numberofadult"), rootB.get("numberofchild"),
                builder.prod(rootT.get("priceforadult").as(BigDecimal.class),
                        rootB.get("numberofadult").as(BigDecimal.class)),
                builder.prod(rootT.get("priceforchild").as(BigDecimal.class),
                        rootB.get("numberofchild").as(BigDecimal.class)),
                rootB.get("bookingid")
        );

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean delBooking(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Booking b = s.get(Booking.class, id);
            s.delete(b);
            return true;
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

}
