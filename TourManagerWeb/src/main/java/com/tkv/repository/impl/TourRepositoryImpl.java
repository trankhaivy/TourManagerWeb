/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.Booking;
import com.tkv.pojo.Tour;
import com.tkv.repository.TourRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> query = builder.createQuery(Tour.class);
        Root root = query.from(Tour.class);
        query.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = builder.like(root.get("tourname").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);

            }
            String typeid = params.get("typeid");
            if (typeid != null) {
                Predicate p = builder.equal(root.get("tourtypes"), Integer.parseInt(typeid));
                predicates.add(p);
            }
            
            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = builder.greaterThanOrEqualTo(root.get("priceforadult").as(Long.class), Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = builder.lessThanOrEqualTo(root.get("priceforadult").as(Long.class), Long.parseLong(tp));
                predicates.add(p);
            }
            query.where(predicates.toArray(Predicate[]::new));
        }
        Query q = session.createQuery(query);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            q.setFirstResult(start);
            q.setMaxResults(size);

        }

        return q.getResultList();
    }

    @Override
    public int countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Tour");
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Tour> getTours() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);

        q.multiselect(rootT.get("image"), rootT.get("tourname"), rootT.get("priceforadult")
                , rootT.get("priceforchild"),rootT.get("tourid"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addTour(Tour tour) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(tour);
            return true;
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Tour getTourById(int tourid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Tour.class, tourid);
    }

    @Override
    public List<Object[]> getHotTours(int num) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
       Root rootT = q.from(Tour.class);
       Root rootB = q.from(Booking.class);
       
       q.where(builder.equal(rootT.get("tourid"), rootB.get("tour")));
       
       q.multiselect(rootT.get("tourid"),rootT.get("image"),rootT.get("tourname"),rootT.get("priceforadult")
               ,rootT.get("priceforchild"),builder.count(rootT.get("tourid")));
       
       q.groupBy(rootT.get("tourid"));
       q.orderBy(builder.desc(rootT.get("tourid")));
       
       Query query = session.createQuery(q);
       
       
       query.setMaxResults(num);
       
       return query.getResultList();
    }

    @Override
    public boolean delTour(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            Tour tour = s.get(Tour.class, id);
            s.delete(tour);
            return true;
        }catch(IllegalStateException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTour(Tour tour) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.update(tour);
            return true;
        }catch(IllegalStateException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

}
