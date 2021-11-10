package bean;

public class MatBang {
    private String id;
    private String dienTich;
    private String trangThai;
    private String tang;
    private LoaiMatBang loaiMatBang;
    private String moTa;
    private String gia;
    private String ngayDB;
    private String ngayKT;

    public MatBang(String id, String dienTich, String trangThai, String tang, LoaiMatBang loaiMatBang, String moTa, String gia, String ngayDB, String ngayKT) {
        this.id = id;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.moTa = moTa;
        this.gia = gia;
        this.ngayDB = ngayDB;
        this.ngayKT = ngayKT;
    }

    public MatBang() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public LoaiMatBang getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(LoaiMatBang loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNgayDB() {
        return ngayDB;
    }

    public void setNgayDB(String ngayDB) {
        this.ngayDB = ngayDB;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }
}
