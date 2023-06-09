package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id")
    })
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_category", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "category_code", referencedColumnName = "code")
    })
    private List<Category> categories;
}
