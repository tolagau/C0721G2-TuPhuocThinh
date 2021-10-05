package models;

import java.util.Objects;

public class Booking {
    private int maBKing;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Customer customer;
    private Facility facility;
    private String loaiDV;

    public Booking() {
    }

    public Booking(int maBKing, String ngayBatDau,
                   String ngayKetThuc, Customer customer1,
                   Facility facility1, String loaiDV) {
        this.maBKing = maBKing;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.customer = customer1;
        this.facility = facility1;
        this.loaiDV = loaiDV;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getMaBKing() {
        return maBKing;
    }

    public void setMaBKing(int maBKing) {
        this.maBKing = maBKing;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBKing=" + maBKing +
                ", ngayBatDau='" + ngayBatDau +
                ", ngayKetThuc='" + ngayKetThuc +
                ", customer=" + customer.getMa() +
                ", facility=" + facility.getTenDV() +
                ", loaiDV='" + loaiDV +
                '}';
    }

    public String getIFBook() {
        return maBKing + "," + ngayBatDau + "," + ngayKetThuc + ","+ customer.getMa() + "," + facility.getTenDV() + "," + loaiDV;
    }

    @Override
    public boolean equals(Object o) {
        Booking booking = (Booking) o;
        return this.getMaBKing() == booking.getMaBKing();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaBKing());
    }
}
