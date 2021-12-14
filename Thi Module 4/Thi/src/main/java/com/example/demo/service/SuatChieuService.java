package com.example.demo.service;

import com.example.demo.model.SuatChieu;
import com.example.demo.repository.ISuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuatChieuService implements ISuatChieuService {

    @Autowired
    ISuatChieuRepository iSuatChieuRepository;

    @Override
    public Iterable<SuatChieu> findAll() {
        return iSuatChieuRepository.findAll();
    }

    @Override
    public Page<SuatChieu> findAll(Pageable pageable) {
        return iSuatChieuRepository.findAll(pageable);
    }

    @Override
    public Page<SuatChieu> findByPhim(String phim, Pageable pageable) {
        return iSuatChieuRepository.findByPhim(phim,pageable);
    }


    @Override
    public Optional<SuatChieu> findById(String id) {
        return iSuatChieuRepository.findById(id);
    }

    @Override
    public void save(SuatChieu suatChieu) {
        iSuatChieuRepository.save(suatChieu);
    }

    @Override
    public void remove(String id) {
        iSuatChieuRepository.deleteById(id);

    }

//
//    @Override
//    public Page<SuatChieu> findAll(Pageable pageable) {
//        return iSuatChieuRepository.findAll(pageable);
//    }
//
//    @Override
//    public Iterable<SuatChieu> findAll() {
//        return iSuatChieuRepository.findAll();
//    }
//
//    @Override
//    public Optional<SuatChieu> findById(String id) {
//        return iSuatChieuRepository.findById(id);
//    }
//
//    @Override
//    public void save(SuatChieu suatChieu) {
//        iSuatChieuRepository.save(suatChieu);
//
//    }
//
//    @Override
//    public void remove(String id) {
//        iSuatChieuRepository.deleteById(id);
//    }
}
