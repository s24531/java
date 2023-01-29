package com.example.demo.services;

import com.example.demo.contract.OrderDto;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.tools.Mapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public List<OrderDto> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(Mapper::mapOrderToDto)
                .toList();
    }

    public OrderDto getOrder(Long id) throws EntityNotFoundException {
        var optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            return Mapper.mapOrderToDto(optional.get());
        } else {
            throw new EntityNotFoundException();
        }

    }
    public void save(OrderDto orderDto) {
        orderRepository.save(Mapper.mapOrderToEntity(orderDto));
    }
    public void delete(Long id) throws EntityNotFoundException {
        var optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
