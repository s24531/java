package com.example.demo.services;

import com.example.demo.contract.ReaderDto;
import com.example.demo.repositories.ReaderRepository;
import com.example.demo.tools.Mapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderDto getBook(Long id) throws EntityNotFoundException {
        var optional = readerRepository.findById(id);
        if (optional.isPresent()) {
            return Mapper.mapReaderToDto(optional.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<ReaderDto> getAll() {
        return readerRepository.findAll()
                .stream()
                .map(Mapper::mapReaderToDto)
                .toList();
    }

    public void save(ReaderDto readerDto) {
        readerRepository.save(Mapper.mapReaderToEntity(readerDto));
    }



    public void delete(Long id) throws EntityNotFoundException {
        var optional = readerRepository.findById(id);
        if (optional.isPresent()) {
            readerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
