package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "electronicBooks")
public class ElectronicBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "electronic_book_name", nullable = false)
    private String electronicBookName;
    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;
}