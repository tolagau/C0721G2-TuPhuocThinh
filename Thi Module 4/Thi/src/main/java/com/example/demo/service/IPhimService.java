package com.example.demo.service;

import com.example.demo.model.Phim;
import com.example.demo.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPhimService {


    Iterable<Phim> findAll();

    Page<Phim> findAll(Pageable pageable);

    Optional<Phim> findById(Integer id);

    void save(Phim phim);

    void remove(Integer id);

}
