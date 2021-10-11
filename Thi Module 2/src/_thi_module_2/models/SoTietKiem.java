package _thi_module_2.models;

public abstract class SoTietKiem {
    private String idSTK;
    private KhachHang khachHang;
    private String dateMo;
    private String dateGui;
    private Double soTien;
    private double laiSuat;

    public SoTietKiem() {
    }

    public SoTietKiem(String idSTK, KhachHang khachHang, String dateMo, String dateGui, Double soTien, double laiSuat) {
        this.idSTK = idSTK;
        this.khachHang = khachHang;
        this.dateMo = dateMo;
        this.dateGui = dateGui;
        this.soTien = soTien;
        this.laiSuat = laiSuat;
    }

    public String getIdSTK() {
        return idSTK;
    }

    public void setIdSTK(String idSTK) {
        this.idSTK = idSTK;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getDateMo() {
        return dateMo;
    }

    public void setDateMo(String dateMo) {
        this.dateMo = dateMo;
    }

    public String getDateGui() {
        return dateGui;
    }

    public void setDateGui(String dateGui) {
        this.dateGui = dateGui;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "idSTK='" + idSTK + '\'' +
                ", khachHang=" + khachHang +
                ", dateMo='" + dateMo + '\'' +
                ", dateGui='" + dateGui + '\'' +
                ", soTien=" + soTien +
                ", laiSuat=" + laiSuat +
                '}';
    }
}