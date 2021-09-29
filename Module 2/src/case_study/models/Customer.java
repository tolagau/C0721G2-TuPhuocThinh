package case_study.models;

public class Customer extends Person {
    private String loaiKH;
    private String diaChi;

    public Customer() {
    }

    public Customer(int ma, String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email, String loaiKH, String diaChi) {
        super(ma, hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
        this.loaiKH = loaiKH;
        this.diaChi = diaChi;
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

    @Override
    public String toString() {
        return "Customer{" +
                "Mã nhân viên=" + getMa() +
                ", Họ tên nhân viên='" + getHoTen() +
                ", Ngày sinh='" + getNgaySinh() +
                ", Giới tính='" + getGioiTinh() +
                ", Số CMND=" + getSoCMND() +
                ", Số điện thoại=" + getSoDT() +
                ", email='" + getEmail() +
                "Loại khách hàng='" + loaiKH +
                ", Địa chỉ='" + diaChi +
                '}';
    }

    public String getIF() {
        return
                +getMa() + "," + getHoTen() + "," + getNgaySinh()
                        + "," + getGioiTinh() + "," + getSoCMND()
                        + "," + getSoDT() + "," + getEmail()
                        + "," + loaiKH + "," + diaChi;

    }
}
