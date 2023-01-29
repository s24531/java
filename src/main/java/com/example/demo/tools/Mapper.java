package com.example.demo.tools;

import com.example.demo.contract.BookDto;
import com.example.demo.contract.OrderDto;
import com.example.demo.contract.ReaderDto;
import com.example.demo.model.Book;
import com.example.demo.model.Order;
import com.example.demo.model.Reader;

public class Mapper {
    public static BookDto mapBookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setCategory(book.getCategory());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setNumbOfPages(book.getNumbOfPages());
        bookDto.setYearOfPublication(book.getYearOfPublication());
        return bookDto;
    }

    public static Book mapBookToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setCategory(bookDto.getCategory());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setNumbOfPages(bookDto.getNumbOfPages());
        bookDto.setYearOfPublication(bookDto.getYearOfPublication());
        return book;
    }


    public static OrderDto mapOrderToDto(Order orders) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orders.getId());
        orderDto.setReaderId(orders.getReaderId());
        orderDto.setBookId(orders.getBookId());
        orderDto.setOrderDate(orders.getOrderDate());
        orderDto.setReceiptDate(orders.getReceiptDate());
        orderDto.setReturnDate(orders.getReturnDate());
        return orderDto;
    }

    public static Order mapOrderToEntity(OrderDto orderDto) {
        Order orders = new Order();
        orders.setId(orderDto.getId());
        orders.setReaderId(orderDto.getReaderId());
        orders.setBookId(orderDto.getBookId());
        orders.setOrderDate(orderDto.getOrderDate());
        orders.setReceiptDate(orderDto.getReceiptDate());
        orders.setReturnDate(orderDto.getReturnDate());
        return orders;
    }


    public static ReaderDto mapReaderToDto(Reader reader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(reader.getId());
        readerDto.setFirstName(reader.getFirstName());
        readerDto.setLastName(reader.getLastName());
        readerDto.setAddress(reader.getAddress());
        readerDto.setCity(reader.getCity());
        readerDto.setTelephoneNum(reader.getTelephoneNum());
        return readerDto;
    }

    public static Reader mapReaderToEntity(ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setId(readerDto.getId());
        reader.setFirstName(readerDto.getFirstName());
        reader.setLastName(readerDto.getLastName());
        reader.setAddress(readerDto.getAddress());
        reader.setCity(readerDto.getCity());
        reader.setTelephoneNum(readerDto.getTelephoneNum());
        return reader;
    }

}
