package com.sample.project.springgraphql.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project_books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;

}
