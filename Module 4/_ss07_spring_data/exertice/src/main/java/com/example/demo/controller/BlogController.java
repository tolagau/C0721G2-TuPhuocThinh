package com.example.demo.controller;

import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("")
    public String showBlog(Model model){
        model.addAttribute("listBlog",blogService.findAll());

        return "list";
    }

}
