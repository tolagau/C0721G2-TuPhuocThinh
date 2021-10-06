package _bt_lam_them_2.models;

public class HoaDon {
    private String maHoaDon;
    private Person person;
    private String ngayKhoiTao;
    private int soLuong;
    private double donGia;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, Person person, String ngayKhoiTao, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.person = person;
        this.ngayKhoiTao = ngayKhoiTao;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }


    public String getNgayKhoiTao() {
        return ngayKhoiTao;
    }

    public void setNgayKhoiTao(String ngayKhoiTao) {
        this.ngayKhoiTao = ngayKhoiTao;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getTinhTien() {
        if (person.getIdPerson().contains("VN")) {
            if (soLuong < ((NguoiVN)person).getDinhMuc()) {
                return this.soLuong * this.donGia;
            } else {
                return this.soLuong * this.donGia + (this.soLuong - ((NguoiVN)person).getDinhMuc()) * 2.5;
            }
        } else {
            return this.soLuong * this.donGia;
        }
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maKH='" + person.getIdPerson() + '\'' +
                ", ngayKhoiTao='" + ngayKhoiTao + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + getTinhTien() +
                '}';
    }

    public String getInfo() {
        return maHoaDon + "," + person + "," + ngayKhoiTao + "," + soLuong + "," + donGia + "," + getTinhTien();
    }
}
