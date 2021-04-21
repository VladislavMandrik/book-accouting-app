package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "electronicBooks")
@EqualsAndHashCode(callSuper = true)
public class ElectronicBook extends BasicEntity {

    @Column(name = "electronic_book_name", nullable = false)
    private String electronicBookName;
    @Column(name = "text_format", nullable = false)
    private String textFormat;
    @Column(name = "dimension", nullable = false)
    private String dimension;
}