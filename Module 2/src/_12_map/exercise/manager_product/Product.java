package _12_map.exercise.manager_product;

public class Product {
    private int maSP;
    private String tenSP;
    private int tienSP;
    private String hangSX;

    public Product() {
    }

    public Product(int maSP, String tenSP,int tienSP, String hangSX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tienSP = tienSP;
        this.hangSX = hangSX;

    }

    public int getTienSP() {
        return tienSP;
    }

    public void setTienSP(int tienSP) {
        this.tienSP = tienSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    @Override
    public String toString() {
        return "Product{" +
                "maSP=" + maSP +
                ", tenSP='" + tenSP + '\'' +
                ", tienSP=" + tienSP +
                ", hangSX='" + hangSX + '\'' +
                '}';
    }
}
