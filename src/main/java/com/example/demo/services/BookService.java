package com.example.demo.services;

import com.example.demo.contract.BookDto;
import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.tools.Mapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookDto getBook(Long id) throws EntityNotFoundException {
        var optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return Mapper.mapBookToDto(optional.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(Mapper::mapBookToDto)
                .toList();
    }

    public Book save(BookDto bookDto) {
        return bookRepository.save(Mapper.mapBookToEntity(bookDto));
    }

    public void delete(Long id) throws EntityNotFoundException {
        var optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
