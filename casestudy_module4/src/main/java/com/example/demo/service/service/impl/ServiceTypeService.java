package com.example.demo.service.service.impl;

import com.example.demo.model.service.ServiceType;
import com.example.demo.repository.service.IServiceTypeRepository;
import com.example.demo.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Integer id) {
        serviceTypeRepository.deleteById(id);
    }
}
