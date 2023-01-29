package com.example.demo.contract;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private Long readerId;
    private Long bookId;
    private Date orderDate;
    private Date receiptDate;
    private Date returnDate;
}
