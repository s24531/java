package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Year;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String title;
    private String author;
    private Integer numbOfPages;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Year yearOfPublication;

//    public void update(Book book) {
//        this.id = book.getId();
//        this.category = book.getCategory();
//        this.title = book.getTitle();
//        this.author = book.getAuthor();
//        this.numb_of_pages = book.getNumb_of_pages();
//        this.year_of_publication = book.getYear_of_publication();
//    }
}
