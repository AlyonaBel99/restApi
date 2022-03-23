package com.example.api.controller;

import com.example.api.exception.ResourceNotFoundException;
import com.example.api.model.Article;
import com.example.api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    // выдача информации о статье по её идентификатору
    @GetMapping("/articale/{id}")
    Article one(@PathVariable Long id) {

        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found with id " + id));
    }

    @GetMapping("/articale/all")
    public List<Article> all() {
            return (List<Article>) articleRepository.findAll();
    }

    // выдача списка всех статей, относящихся к указанной категории
    @GetMapping("/articale/category/{categoryName}")
    public List<Article> getCategoryName (@PathVariable String categoryName) {
        return articleRepository.findByCategoryName(categoryName);
    }
    // выдача списка всех статей конкретного автора
    @GetMapping("/articale/author/{authorName}")
    public List<Article> getAuthorName (@PathVariable String authorName) {
        String[] parts = authorName.split(" ");
        return articleRepository.findByAuthorName(parts[0], parts[1]);
    }

    // выдача списка всех статей, относящихся к указанному тегу
    @GetMapping("/articale/tag/{tagName}")
    public List<Article> getTagName (@PathVariable String tagName) {
        return articleRepository.findByTagName(tagName);
    }

    // выдача списка всех статей за текущий день
    @GetMapping("/articale/date/{date}")
    public List<Article> getPublicationDate (@PathVariable String date) {
        LocalDate date1 = LocalDate.parse(date);
        return articleRepository.findByPublicationDate(date1);
    }

}
