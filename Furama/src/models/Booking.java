package models;

public class Booking {
    private int maBKing;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int customer;
    private String facility;
    private int maKh;
    private String tenDV;
    private String loaiDV;

    public Booking() {
    }

    public Booking(int maBKing, String ngayBatDau,
                   String ngayKetThuc, Customer customer1,
                   Facility facility1, String loaiDV) {
        this.maBKing = maBKing;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.customer = customer1.getMa();
        this.facility = facility1.getTenDV();
        this.loaiDV = loaiDV;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public int getMaBKing() {
        return maBKing;
    }

    public void setMaBKing(int maBKing) {
        this.maBKing = maBKing;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBKing=" + maBKing +
                ", ngayBatDau='" + ngayBatDau +
                ", ngayKetThuc='" + ngayKetThuc +
                ", customer=" + customer +
                ", facility=" + facility +
                ", loaiDV='" + loaiDV +
                '}';
    }

    public String getIFBook() {
        return
                maBKing + "," + ngayBatDau + "," + ngayKetThuc + ", "
                        + customer + ", " + facility + ", " + loaiDV;
    }

}
