package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "articles")
public class Article implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "article_name")
    private String articleName;
    @Column(columnDefinition = "summary", nullable = false)
    private String summary;
    @Column(columnDefinition = "content", nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Column(columnDefinition = "publication_date", nullable = false)
    private LocalDateTime publicationDate;
    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tag> tags = new HashSet<>();

    public Article() {}

    public Article(String name, String summary, String content, LocalDateTime date, Author author, Category category) {
        this.articleName = name;
        this.summary = summary;
        this.content = content;
        this.publicationDate = date;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return articleName;
    }

    public void setName(String name) {
        this.articleName = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(articleName, article.articleName)
                && Objects.equals(summary, article.summary) && Objects.equals(content, article.content)
                && Objects.equals(author, article.author) && Objects.equals(category, article.category)
                && Objects.equals(publicationDate, article.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleName, summary, content, author, category, publicationDate);
    }

    @Override
    public String toString() {
        return "\nArticle{" +
                "id=" + id +
                ", name='" + articleName + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", date=" + publicationDate +
                '}';
    }
}
