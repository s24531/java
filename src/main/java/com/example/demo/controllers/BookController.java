package com.example.demo.controllers;

import com.example.demo.contract.BookDto;
import com.example.demo.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/library/books")
public class BookController {

    private final BookService bookService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping()
    public ResponseEntity<Object> getAllBooks() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBook(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping()
    public ResponseEntity<Object> saveBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/add")
    public ResponseEntity<Object> updateBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        try {
            bookService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

