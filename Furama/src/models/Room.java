package models;

public class Room extends Facility{
    private String dichVuDiKem;

    public Room() {
    }

    public Room(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
    }

    public Room(String dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public Room(String tenDV, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuDiKem) {
        super(tenDV, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.dichVuDiKem = dichVuDiKem;
    }

    public String getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(String dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

}
