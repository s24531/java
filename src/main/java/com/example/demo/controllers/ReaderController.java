package com.example.demo.controllers;

import com.example.demo.contract.ReaderDto;
import com.example.demo.services.ReaderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/readers")
public class ReaderController {

    private final ReaderService readerService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping()
    public ResponseEntity<Object> getAllReaders() {
        return new ResponseEntity<>(readerService.getAll(), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReader(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(readerService.getBook(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping()
    public ResponseEntity<Object> saveReader(@RequestBody ReaderDto readerDto) {
        readerService.save(readerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/add")
    public ResponseEntity<Object> updateBook(@RequestBody ReaderDto readerDto) {
        readerService.save(readerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReader(@PathVariable Long id) {
        try {
            readerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
