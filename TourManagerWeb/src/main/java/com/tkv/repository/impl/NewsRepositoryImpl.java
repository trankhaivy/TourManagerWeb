/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository.impl;

import com.tkv.pojo.News;
import com.tkv.pojo.Tour;
import com.tkv.repository.NewsRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addNews(News news) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(news);
            return true;
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<News> getListNews() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<News> query = builder.createQuery(News.class);
        Root root = query.from(News.class);
        query.select(root);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public News getNewsById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(News.class, id);
    }

}
