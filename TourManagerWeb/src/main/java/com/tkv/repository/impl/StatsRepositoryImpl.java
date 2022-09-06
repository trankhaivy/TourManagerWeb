/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Booking;
import com.tkv.pojo.Tour;
import com.tkv.repository.StatsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> tourStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(rootT.get("tourid"), rootB.get("tour")));

        q.multiselect(rootT.get("tourid"), rootT.get("tourname"),
                builder.sum(
                        builder.prod(rootT.get("priceforadult").as(BigDecimal.class),
                                rootB.get("numberofadult").as(BigDecimal.class)),
                        builder.prod(rootT.get("priceforchild").as(BigDecimal.class),
                                rootB.get("numberofchild").as(BigDecimal.class))
                )
        );
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(rootT.get("tourname"), String.format("%%%s%%", kw)));
        }
        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootB.get("bookingdate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootB.get("bookingdate"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rootT.get("tourid"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> tourMonthStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(rootT.get("tourid"), rootB.get("tour")));

        q.multiselect(builder.function("MONTH",Integer.class,rootB.get("bookingdate")),
                builder.function("YEAR",Integer.class,rootB.get("bookingdate")),
                builder.sum(
                        builder.prod(rootT.get("priceforadult").as(BigDecimal.class),
                                rootB.get("numberofadult").as(BigDecimal.class)),
                        builder.prod(rootT.get("priceforchild").as(BigDecimal.class),
                                rootB.get("numberofchild").as(BigDecimal.class))
                )
        );
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(rootT.get("tourname"), String.format("%%%s%%", kw)));
        }
        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootB.get("bookingdate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootB.get("bookingdate"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(builder.function("MONTH",Integer.class,rootB.get("bookingdate")),
                builder.function("YEAR",Integer.class,rootB.get("bookingdate")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> tourQuarterStats(int quarter, int y) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);


        q.where(builder.equal(rootT.get("tourid"), rootB.get("tour")),
               builder.equal(builder.function("QUARTER", Integer.class,rootB.get("bookingdate")), quarter),
               builder.equal(builder.function("YEAR", Integer.class,rootB.get("bookingdate")), y)
                );

        q.multiselect(
                rootT.get("tourid"),rootT.get("tourname"),
                builder.sum(
                        builder.prod(rootT.get("priceforadult").as(BigDecimal.class),
                                rootB.get("numberofadult").as(BigDecimal.class)),
                        builder.prod(rootT.get("priceforchild").as(BigDecimal.class),
                                rootB.get("numberofchild").as(BigDecimal.class))
                )
        );
        
        q.groupBy(rootT.get("tourid"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

}
