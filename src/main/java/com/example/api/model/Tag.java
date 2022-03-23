package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "tag_name", nullable = false)
    private String tagName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Tag() {}

    public Tag(Long id, String name, Article article) {
        this.id = id;
        this.tagName = name;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(tagName, tag.tagName) && Objects.equals(article, tag.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, article);
    }

    @Override
    public String toString() {
        return "\nTag{" +
                "id=" + id +
                ", name='" + tagName + '\'' +
                ", article=" + article +
                '}';
    }
}
