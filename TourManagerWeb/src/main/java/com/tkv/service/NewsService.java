/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tkv.service;

import com.tkv.pojo.News;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NewsService {

    boolean addNews(News news);

    List<News> getListNews();

    News getNewsById(int id);
}
