package com.example.demo.repository;

import com.example.demo.model.Phim;
import com.example.demo.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuatChieuRepository extends JpaRepository<SuatChieu, String> {


    @Query(value = " select *\n" +
            " from suat_chieu\n" +
            " join phim on suat_chieu.phim_id = phim.id\n" +
            " where phim.name like concat('%',:phim,'%')", nativeQuery = true)
    Page<SuatChieu> findByPhim(@Param("phim") String phim, Pageable pageable);

}
