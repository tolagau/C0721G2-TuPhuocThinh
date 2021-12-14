package com.example.demo.service.service.impl;

import com.example.demo.model.service.Services;
import com.example.demo.repository.service.IServiceRepository;
import com.example.demo.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Iterable<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Services> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Optional<Services> findById(String id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        serviceRepository.findById(id);
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public void remove(Integer id) {

    }
}
