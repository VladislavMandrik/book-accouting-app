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
public class Book extends BasicEntity {

    @Column(name = "book_name", nullable = false)
    private String bookName;
}