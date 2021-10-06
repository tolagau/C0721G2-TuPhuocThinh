package models;

public class Villa extends Facility {
    private String tieuChuan;
    private double dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String idDV, String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        super(idDV, tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
    }

    public Villa(String tieuChuan, double dienTichHoBoi, int soTang) {
        this.tieuChuan = tieuChuan;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String idDV, String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuan, double dienTichHoBoi, int soTang) {
        super(idDV, tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.tieuChuan = tieuChuan;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(String tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "maDV='" + getIdDV() +
                "tenDV='" + getTenDV() +
                ", dienTich=" + getDienTich() +
                ", chiPhi=" + getChiPhi() +
                ", soLuongNguoi=" + getSoLuongNguoi() +
                ", kieuThue='" + getKieuThue() +
                "tieuChuan='" + tieuChuan +
                ", dienTichHoBoi=" + dienTichHoBoi +
                ", soTang=" + soTang +
                '}';
    }
    public String getInfoVl(){
        return getTenDV() + "," + getDienTich() + "," + getChiPhi() + "," + getSoLuongNguoi() + "," + getKieuThue() +","+ tieuChuan +","+dienTichHoBoi +","+soTang;
    }
}