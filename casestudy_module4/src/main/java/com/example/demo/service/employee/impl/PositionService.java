package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.Position;
import com.example.demo.repository.employee.IPositionRepository;
import com.example.demo.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Integer id) {
        positionRepository.deleteById(id);
    }
}
