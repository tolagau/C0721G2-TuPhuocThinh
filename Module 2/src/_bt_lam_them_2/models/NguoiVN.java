package _bt_lam_them_2.models;

public class NguoiVN extends Person {
    private String loaiKH;
    private int dinhMuc;

    public NguoiVN() {
    }

    public NguoiVN(String idPerson, String name) {
        super(idPerson, name);
    }

    public NguoiVN(String loaiKH, int tieuThu, int dinhMuc) {
        this.loaiKH = loaiKH;

        this.dinhMuc = dinhMuc;
    }

    public NguoiVN(String idPerson, String name, String loaiKH, int dinhMuc) {
        super(idPerson, name);
        this.loaiKH = loaiKH;

        this.dinhMuc = dinhMuc;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }


    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    @Override
    public String toString() {
        return "NguoiVN{" + "idPerson='" + getIdPerson() + ", name='" + getName() + ", loaiKH='" + loaiKH + ", dinhMuc=" + dinhMuc + '}';
    }

    public String getInfoVN() {
        return getIdPerson() + "," + getName() + "," + loaiKH + "," + dinhMuc;
    }
}
