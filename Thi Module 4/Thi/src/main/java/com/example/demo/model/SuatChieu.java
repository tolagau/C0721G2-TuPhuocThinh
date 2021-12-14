package com.example.demo.model;

import com.example.demo.sequence_id_generator.CustomIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table
@Entity
public class SuatChieu {


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thinh_seq")
    @GenericGenerator(
            name = "thinh_seq",
            strategy = "com.example.demo.sequence_id_generator.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "CI-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})

    @Id
    private String id;
    @ManyToOne(targetEntity = Phim.class)
    private Phim phim;
    @Column(name = "dateNow", columnDefinition = "VARCHAR(45)")
    @FutureOrPresent(message = "hiện tại và tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "không bỏ trống")
    private LocalDate dateNow;
    @Column(name = "quantity", columnDefinition = "int")
    @NotNull(message = "không bỏ trống")
    @Min(value = 1, message = "Wrong format, Must be positive")
    private int quantity;

    public SuatChieu() {
    }

    public SuatChieu(String id, Phim phim, LocalDate dateNow, int quantity) {
        this.id = id;
        this.phim = phim;
        this.dateNow = dateNow;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
