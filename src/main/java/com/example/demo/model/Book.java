package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "books")
@EqualsAndHashCode(callSuper = true)
public class Book extends BasicEntity{

    @Column(name = "book_name", nullable = false)
    private String bookName;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;
    @Column(name = "year_of_publishing", nullable = false)
    private String yearOfPublishing;
}