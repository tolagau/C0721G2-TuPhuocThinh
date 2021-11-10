package bean;

public class HocSinh {
    private String id;
    private String name;
    private String lop;

    public HocSinh(String id) {
        this.id = id;
    }

    public HocSinh(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public HocSinh() {
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

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
