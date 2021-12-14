package com.example.demo.service.contract.impl;

import com.example.demo.model.contract.AttachService;
import com.example.demo.repository.contract.IAttachServiceRepository;
import com.example.demo.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        attachServiceRepository.deleteById(id);
    }
}
