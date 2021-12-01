package com.example.demo.service;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findBlogsByNameContaining(String name, Pageable pageable);

    Page<Blog> findAllBlogByCategoriseId(@Param("id") Integer categoriseId, Pageable pageable);

    Page<Blog> findAllBlogs(Pageable pageable);


}