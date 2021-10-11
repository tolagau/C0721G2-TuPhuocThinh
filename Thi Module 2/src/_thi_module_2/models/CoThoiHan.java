package _thi_module_2.models;

public class CoThoiHan extends SoTietKiem {
    private String kyHan;

    public CoThoiHan() {
    }

    public CoThoiHan(String idSTK, KhachHang khachHang, String dateMo, String kyHan, Double soTien, double laiSuat) {
        super(idSTK, khachHang, dateMo, kyHan, soTien, laiSuat);
    }

    public CoThoiHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public CoThoiHan(String idSTK, KhachHang khachHang, String dateMo, String kyHan, Double soTien, double laiSuat, String kyHan1) {
        super(idSTK, khachHang, dateMo, kyHan, soTien, laiSuat);
        this.kyHan = kyHan1;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "CoThoiHan{" +
                "kyHan='" + kyHan + '\'' +
                '}';
    }

    public String getInfoCoThoiHan() {
        return getIdSTK() + "," + getKhachHang().getIdKH() + "," + getDateMo() + "," +
                getDateMo() + "," + getSoTien() + "," + getLaiSuat() + kyHan;
    }
}
