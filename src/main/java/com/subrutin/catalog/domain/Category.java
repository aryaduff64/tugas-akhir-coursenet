package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
