package com.example.api.repository;

import com.example.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author,Long> {

}
