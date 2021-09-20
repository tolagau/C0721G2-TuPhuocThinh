package case_study.models;

public class Customer extends Person{
    private int maKH;
    private String loaiKH;
    private String diaChi;

    public Customer(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
    }

    public Customer() {
    }

    public Customer(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email, int maKH, String loaiKH, String diaChi) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
        this.maKH = maKH;
        this.loaiKH = loaiKH;
        this.diaChi = diaChi;
    }

    public Customer(int maKH, String loaiKH, String diaChi) {
        this.maKH = maKH;
        this.loaiKH = loaiKH;
        this.diaChi = diaChi;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
