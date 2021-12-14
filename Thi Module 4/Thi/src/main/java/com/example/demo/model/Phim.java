package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Phim {


    @Id
    private int id;
    @Column(name = "name",columnDefinition = "VARCHAR(45)")
    private String name;
    @OneToMany(targetEntity = SuatChieu.class,mappedBy = "phim")
    List<SuatChieu> suatChieuList;

    public Phim() {
    }

    public Phim(int id, String name, List<SuatChieu> suatChieuList) {
        this.id = id;
        this.name = name;
        this.suatChieuList = suatChieuList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuatChieu> getSuatChieuList() {
        return suatChieuList;
    }

    public void setSuatChieuList(List<SuatChieu> suatChieuList) {
        this.suatChieuList = suatChieuList;
    }
}
