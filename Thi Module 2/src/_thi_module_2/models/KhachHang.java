package _thi_module_2.models;

public class KhachHang {
    private String idKH;
    private String tenKH;
    private String ngaySinh;
    private String gioiTinh;
    private String sdt;
    private String addr;

    public KhachHang() {
    }

    public KhachHang(String idKH, String tenKH, String ngaySinh, String gioiTinh, String sdt, String addr) {
        this.idKH = idKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.addr = addr;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "idKH='" + idKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", sdt='" + sdt + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

}
