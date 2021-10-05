package models;

public class Contract {
    private int soHD;
    private int mHD;
    private double tienCocTruoc;
    private double tongTienThanhToan;
    private int maKH;

    public Contract() {
    }

    public Contract(int soHD, int mHD, double tienCocTruoc, double tongTienThanhToan, int maKH) {
        this.soHD = soHD;
        this.mHD = mHD;
        this.tienCocTruoc = tienCocTruoc;
        this.tongTienThanhToan = tongTienThanhToan;
        this.maKH = maKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public int getmHD() {
        return mHD;
    }

    public void setmHD(int mHD) {
        this.mHD = mHD;
    }

    public double getTienCocTruoc() {
        return tienCocTruoc;
    }

    public void setTienCocTruoc(double tienCocTruoc) {
        this.tienCocTruoc = tienCocTruoc;
    }

    public double getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(double tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "soHD=" + soHD +
                ", mHD=" + mHD +
                ", tienCocTruoc=" + tienCocTruoc +
                ", tongTienThanhToan=" + tongTienThanhToan +
                ", maKH=" + maKH +
                '}';
    }

    public String getIFCon() {
        return soHD + "," + mHD + "," + tienCocTruoc + "," + tongTienThanhToan + "," + maKH;
    }
}
