package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    List<Blog> findAll();

    Blog findById(int id);
}
