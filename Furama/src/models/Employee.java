package models;

public class Employee extends Person{
    private int maNV;
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
    }

    public Employee() {
    }

    public Employee(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email, int maNV, String trinhDo, String viTri, double luong) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
        this.maNV = maNV;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public Employee(int maNV, String trinhDo, String viTri, double luong) {
        this.maNV = maNV;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
