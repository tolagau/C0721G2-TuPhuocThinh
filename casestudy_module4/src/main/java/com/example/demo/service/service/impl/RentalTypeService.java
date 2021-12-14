package com.example.demo.service.service.impl;

import com.example.demo.model.service.RentalType;
import com.example.demo.repository.service.IRentalTypeRepository;
import com.example.demo.service.service.IRentalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RentalTypeService implements IRentalTypeService {
    @Autowired
    IRentalTypeRepository rentalTypeRepository;

    @Override
    public Iterable<RentalType> findAll() {
        return rentalTypeRepository.findAll();
    }

    @Override
    public Optional<RentalType> findById(Integer id) {
        return rentalTypeRepository.findById(id);
    }

    @Override
    public void save(RentalType rentalType) {
        rentalTypeRepository.save(rentalType);
    }

    @Override
    public void remove(Integer id) {
        rentalTypeRepository.deleteById(id);
    }
}
