package com.example.demo.service.service;

import com.example.demo.model.service.Services;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IServiceService extends IGeneralService<Services> {
    Page<Services> findAll(Pageable pageable);

    Optional<Services> findById(String id);

    void remove(String id);
}
