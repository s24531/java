package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long readerId;
    private Long bookId;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date orderDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date receiptDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date returnDate;

}
