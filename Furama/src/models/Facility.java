package models;

import java.util.Date;

public abstract class Facility {
    private String idDV;
    private String tenDV;
    private double dienTich;
    private double chiPhi;
    private int soLuongNguoi;
    private String kieuThue;

    public Facility() {
    }

    public Facility(String idDV, String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        this.idDV = idDV;
        this.tenDV = tenDV;
        this.dienTich = dienTich;
        this.chiPhi = chiPhi;
        this.soLuongNguoi = soLuongNguoi;
        this.kieuThue = kieuThue;
    }

    public String getIdDV() {
        return idDV;
    }

    public void setIdDV(String idDV) {
        this.idDV = idDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idDV='" + idDV + '\'' +
                ", tenDV='" + tenDV + '\'' +
                ", dienTich=" + dienTich +
                ", chiPhi=" + chiPhi +
                ", soLuongNguoi=" + soLuongNguoi +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }

    public String getInfo() {
        return getIdDV() + "," + getTenDV() + "," + getDienTich() + ","
                + getChiPhi() + "," + getSoLuongNguoi() + "," + getKieuThue() + ",";
    }
}
