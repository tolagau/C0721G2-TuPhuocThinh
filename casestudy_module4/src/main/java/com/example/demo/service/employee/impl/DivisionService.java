package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.Division;
import com.example.demo.repository.employee.IDivisionRepository;
import com.example.demo.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return divisionRepository.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }
}
