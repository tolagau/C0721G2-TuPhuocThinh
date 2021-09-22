package case_study.models;

public class Employee extends Person{
    private String trinhDo;
    private String viTri;
    private double luong;
    public Employee() {
    }

    public Employee(int ma, String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email, String trinhDo, String viTri, double luong) {
        super(ma, hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
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

    @Override
    public String toString() {
        return "Employee{" +
                "Mã nhân viên=" + getMa() +
                ", Họ tên nhân viên='" + getHoTen() +
                ", Ngày sinh='" + getNgaySinh() +
                ", Giới tính='" + getGioiTinh() +
                ", Số CMND=" + getSoCMND() +
                ", Số điện thoại=" + getSoDT() +
                ", email='" + getEmail() +
                "Trình độ='" + trinhDo +
                ", Vị trí='" + viTri +
                ", Lương=" + luong +
                '}';
    }
}
