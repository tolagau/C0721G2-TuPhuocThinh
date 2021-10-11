package _thi_module_2.models;

public class VoThoiHan extends SoTietKiem {

    public VoThoiHan() {
    }

    public VoThoiHan(String idSTK, KhachHang khachHang, String dateMo, String dateGui, Double soTien, double laiSuat) {
        super(idSTK, khachHang, dateMo, dateGui, soTien, laiSuat);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getInfoVoThoiHan() {
        return getIdSTK() + "," + getKhachHang().getIdKH() + "," + getDateMo() + "," +
                getDateMo() + "," + getSoTien() + "," + getLaiSuat();
    }
}
