package com.example.demo.repositories;

import com.example.demo.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {
    Optional<Reader> findReaderByFirstName(String firstName);

    Optional<Reader> findReaderByLastName(String lastName);

    List<Reader> findAllById(Long id);

    Optional<Reader> findReaderByTelephoneNum(String telephoneNum);

}
