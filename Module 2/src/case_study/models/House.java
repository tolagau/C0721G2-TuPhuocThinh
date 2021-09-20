package case_study.models;

public class House extends Facility{
    private String tieuChuan;
    private int soTang;

    public House() {
    }

    public House(String tieuChuan, int soTang) {
        this.tieuChuan = tieuChuan;
        this.soTang = soTang;
    }

    public House(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
    }

    public House(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuan, int soTang) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.tieuChuan = tieuChuan;
        this.soTang = soTang;
    }

    public String getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(String tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }
}
