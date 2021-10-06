package models;

public class Room extends Facility{
    private String dichVuDiKem;

    public Room() {
    }

    public Room(String idDV, String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        super(idDV, tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
    }

    public Room(String idDV, String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuDiKem) {
        super(idDV, tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.dichVuDiKem = dichVuDiKem;
    }

    public String getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(String dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    @Override
    public String toString() {
        return "Room{" +
                "maDV='" + getIdDV() +
                "tenDV='" + getTenDV() +
                ", dienTich=" + getDienTich() +
                ", chiPhi=" + getChiPhi() +
                ", soLuongNguoi=" + getSoLuongNguoi() +
                ", kieuThue='" + getKieuThue() +
                "dichVuDiKem='" + dichVuDiKem +
                '}';
    }
    public String getInfoRoom(){
        return getIdDV() + "," +getTenDV() + "," + getDienTich() + "," + getChiPhi() + ","
                + getSoLuongNguoi() + "," + getKieuThue() +","+ dichVuDiKem;
    }
}
