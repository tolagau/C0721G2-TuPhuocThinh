package _thi_module_2.models;

public class DaiHan extends SoTietKiem {
    private String kyHan;
    private String uuDai;

    public DaiHan() {
    }

    public DaiHan(String idSTK, KhachHang khachHang, String dateMo, String dateGui, Double soTien, double laiSuat) {
        super(idSTK, khachHang, dateMo, dateGui, soTien, laiSuat);
    }

    public DaiHan(String kyHan, String uuDai) {
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public DaiHan(String idSTK, KhachHang khachHang, String dateMo, String dateGui, Double soTien, double laiSuat, String kyHan, String uuDai) {
        super(idSTK, khachHang, dateMo, dateGui, soTien, laiSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    public String getInfoDai() {
        return getIdSTK() + "," + getKhachHang().getIdKH() + "," + getDateMo() + "," + getDateGui() +
                "," + getSoTien() + "," + getLaiSuat() + "," + uuDai ;
    }
}
