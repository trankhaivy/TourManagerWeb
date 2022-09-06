/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.controllers;

import com.tkv.pojo.News;
import com.tkv.pojo.Tour;
import com.tkv.service.NewsService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news")
    public String listNews(Model model) {
        model.addAttribute("listnews", this.newsService.getListNews());
        return "listnews";
    }

    @GetMapping(value = "/admin/news")
    public String list(Model model) {
        model.addAttribute("news", new News());
        return "news";
    }

    @GetMapping("/news/{newsid}")
    public String detail(Model model,@PathVariable(value = "newsid") int newsid){
        model.addAttribute("newsdetail",this.newsService.getNewsById(newsid));
        return "newsdetail";
    }
    @PostMapping("/admin/news")
    public String addNews(Model model, @ModelAttribute(value = "news") @Valid News news,
            BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "news";
        }
        if (!result.hasErrors()) {
            if (news != null) {
                if (this.newsService.addNews(news) == true) {
                    return "redirect:/";
                } else {
                    return "news";
                }
            }
        }
        return "news";
    }
}
