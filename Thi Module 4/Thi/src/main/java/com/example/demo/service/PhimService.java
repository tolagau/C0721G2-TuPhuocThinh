package com.example.demo.service;

import com.example.demo.model.Phim;
import com.example.demo.repository.IPhimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PhimService implements IPhimService {
    @Autowired
    IPhimeRepository iPhimeRepository;

    @Override
    public Iterable<Phim> findAll() {
        return iPhimeRepository.findAll();
    }

    @Override
    public Page<Phim> findAll(Pageable pageable) {
        return iPhimeRepository.findAll(pageable);
    }

    @Override
    public Optional<Phim> findById(Integer id) {
        return iPhimeRepository.findById(id);
    }

    @Override
    public void save(Phim phim) {
        iPhimeRepository.save(phim);
    }

    @Override
    public void remove(Integer id) {
        iPhimeRepository.deleteById(id);
    }

//    @Override
//    public Page<Phim> findAll(Pageable pageable) {
//        return iPhimeRepository.findAll(pageable);
//    }
//
//    @Override
//    public Iterable<Phim> findAll() {
//        return iPhimeRepository.findAll();
//    }
//
//    @Override
//    public Optional<Phim> findById(Integer id) {
//        return iPhimeRepository.findById(id);
//    }
//
//    @Override
//    public void save(Phim phim) {
//        iPhimeRepository.save(phim);
//    }
//
//    @Override
//    public void remove(Integer id) {
//        iPhimeRepository.deleteById(id);
//    }
}
