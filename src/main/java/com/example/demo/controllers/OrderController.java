package com.example.demo.controllers;

import com.example.demo.contract.OrderDto;
import com.example.demo.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/orders")
public class OrderController {

    private final OrderService orderService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping()
    public ResponseEntity<Object> getAllReaders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReader(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/add")
    public ResponseEntity<Object> updateBook(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping()
    public ResponseEntity<Object> saveReader(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReader(@PathVariable Long id) {
        try {
            orderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
