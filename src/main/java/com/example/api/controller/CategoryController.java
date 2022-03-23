package com.example.api.controller;

import com.example.api.model.Author;
import com.example.api.model.Category;
import com.example.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("/categorys")
    public List<Category> all() {
        return repository.findAll();
    }

}
