package com.example.api.controller;

import com.example.api.exception.ResourceNotFoundException;
import com.example.api.model.Article;
import com.example.api.repository.ArticleRepository;
import com.example.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articale/{id}")
    Article one(@PathVariable Long id) {

        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found with id " + id));
    }
// Вывод статей по идентификатору (5)
    @GetMapping("/articale/all")
    public List<Article> all() {
            return (List<Article>) articleRepository.findAll();
    }

    @GetMapping("/articale/category/{categoryName}")
    public List<Article> getCategoryName (@PathVariable String categoryName) {

        return articleRepository.findByCategoryName(categoryName);
    }

    @GetMapping("/articale/author/{authorName}")
    public List<Article> getAuthorName (@PathVariable String authorName) {
        String[] parts = authorName.split(" ");
        return articleRepository.findByAuthorName(parts[0], parts[1]);
    }

    @GetMapping("/articale/tag/{tagName}")
    public List<Article> getTagName (@PathVariable String tagName) {

        return articleRepository.findByTagName(tagName);
    }

    @GetMapping("/articale/date/{date}")
    public List<Article> getPublicationDate (@PathVariable String date) {
        LocalDate date1 = LocalDate.parse(date);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDate.now().atStartOfDay();
        //Timestamp timestamp = Timestamp.valueOf(date);
        System.out.println(date1);
        return articleRepository.findByPublicationDate(date1);
    }

}
