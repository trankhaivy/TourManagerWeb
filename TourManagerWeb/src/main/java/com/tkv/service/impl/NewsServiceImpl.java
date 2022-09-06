/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tkv.pojo.News;
import com.tkv.repository.NewsRepository;
import com.tkv.service.NewsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepository ;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public boolean addNews(News news) {
        try {
            Map results = this.cloudinary.uploader().upload(news.getNewsImage().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            news.setImage((String) results.get("secure_url"));
            return this.newsRepository.addNews(news);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<News> getListNews() {
        return this.newsRepository.getListNews();
    }

    @Override
    public News getNewsById(int id) {
        return this.newsRepository.getNewsById(id);
    }
    
}
