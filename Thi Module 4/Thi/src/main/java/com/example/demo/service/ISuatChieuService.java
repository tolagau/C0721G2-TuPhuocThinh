package com.example.demo.service;

import com.example.demo.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISuatChieuService {

    Iterable<SuatChieu> findAll();

    Page<SuatChieu> findAll(Pageable pageable);

    Page<SuatChieu> findByPhim(String phim, Pageable pageable);

    Optional<SuatChieu> findById(String id);

    void save(SuatChieu suatChieu);

    void remove(String id);


}
