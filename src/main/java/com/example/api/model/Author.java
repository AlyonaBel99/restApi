package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "authors")
public class Author implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "first_name", nullable = false)
    private String firstName;
    @Column(columnDefinition = "last_name", nullable = false)
    private String lastName;
    /*@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Author> authors = new HashSet<>();*/

    public Author() { }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
     if (this == o) return true;
     if (!(o instanceof Author)) return false;
     Author author = (Author) o;
     return Objects.equals(this.id, author.id) && Objects.equals(this.firstName, author.firstName)
             && Objects.equals(this.lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName);
    }

    @Override
    public String toString() {
        return "\nAuthor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
