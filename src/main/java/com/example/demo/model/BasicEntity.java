package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;
    @Column(name = "year_of_publishing", nullable = false)
    private String yearOfPublishing;
}
