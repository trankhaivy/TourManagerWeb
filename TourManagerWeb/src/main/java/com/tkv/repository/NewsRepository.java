/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.repository;

import com.tkv.pojo.News;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NewsRepository {
    boolean addNews(News news);
    List<News> getListNews();
    News getNewsById(int id);
}
