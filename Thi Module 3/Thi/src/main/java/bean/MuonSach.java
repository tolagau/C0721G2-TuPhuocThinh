package bean;

public class MuonSach {
    private String id;
    private Sach sach;
    private HocSinh hocSinh;
    private String trangThai;
    private String checkIn;
    private String checkOut;

    public MuonSach() {
    }

    public MuonSach(String id, Sach sach, HocSinh hocSinh, String trangThai, String checkIn, String checkOut) {
        this.id = id;
        this.sach = sach;
        this.hocSinh = hocSinh;
        this.trangThai = trangThai;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public MuonSach(String id, Sach sach, HocSinh hocSinh, String checkIn, String checkOut) {
        this.id = id;
        this.sach = sach;
        this.hocSinh = hocSinh;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
