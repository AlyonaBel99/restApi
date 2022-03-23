package com.example.api.repository;
import com.example.api.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long>{
   @Query(value = "select * from articles a join categorys c on a.category_id = c.id where c.category_name like %?1", nativeQuery = true)
    List<Article> findByCategoryName(String categoryName);
    @Query(value = "select * from articles a join authors au on a.author_id = au.id where au.first_name like %?1% and last_name like %?2%", nativeQuery = true)
    List<Article> findByAuthorName(String firstName, String lastName);
    @Query(value = "select * from articles a join tags t on a.id = t.article_id where t.tag_name like %?1", nativeQuery = true)
    List<Article> findByTagName(String name);
   @Query(value = "select * from articles a where date(a.publication_date) = ?1", nativeQuery = true)
    List<Article> findByPublicationDate(LocalDate date);

}
