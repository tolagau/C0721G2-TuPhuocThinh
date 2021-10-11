package _test_bt_thi.models;

public class RapPhim {
    private String maSuat;
    private String tenPhim;
    private String ngayChieu;
    private int soVe;

    public RapPhim() {
    }

    public RapPhim(String maSuat, String tenPhim, String ngayChieu, int soVe) {
        this.maSuat = maSuat;
        this.tenPhim = tenPhim;
        this.ngayChieu = ngayChieu;
        this.soVe = soVe;
    }

    public String getMaSuat() {
        return maSuat;
    }

    public void setMaSuat(String maSuat) {
        this.maSuat = maSuat;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getSoVe() {
        return soVe;
    }

    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }

    @Override
    public String toString() {
        return "RapPhim{" +
                "maSuat='" + maSuat + '\'' +
                ", tenPhim='" + tenPhim + '\'' +
                ", ngayChieu='" + ngayChieu + '\'' +
                ", soVe=" + soVe +
                '}';
    }

    public String getInfo() {
        return maSuat + "," + tenPhim + "," + ngayChieu + "," + soVe;
    }
}
