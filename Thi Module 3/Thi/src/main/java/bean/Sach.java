package bean;

public class Sach {
    private String id;
    private String name;
    private String tacGia;
    private String moTa;
    private int soLuong;

    public Sach(String id) {
        this.id = id;
    }

    public Sach(String id, String name, String tacGia, String moTa, int soLuong) {
        this.id = id;
        this.name = name;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public Sach(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sach() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
