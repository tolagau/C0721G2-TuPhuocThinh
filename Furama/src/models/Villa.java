package models;

public class Villa extends Facility {
    private String tieuChuan;
    private double dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
    }

    public Villa(String tieuChuan, double dienTichHoBoi, int soTang) {
        this.tieuChuan = tieuChuan;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuan, double dienTichHoBoi, int soTang) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
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
                "tieuChuan='" + tieuChuan + '\'' +
                ", dienTichHoBoi=" + dienTichHoBoi +
                ", soTang=" + soTang +
                '}';
    }
}
