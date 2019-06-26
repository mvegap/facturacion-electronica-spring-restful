package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.model.Blog;
import com.miguelvega.apifacturaelectronica.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    // get all blogs
    @GetMapping("/blogs")
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }
}
