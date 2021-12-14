package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.EducationDegree;
import com.example.demo.repository.employee.IEducationDegreeRepository;
import com.example.demo.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return educationDegreeRepository.findById(id);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Integer id) {
        educationDegreeRepository.deleteById(id);
    }
}
