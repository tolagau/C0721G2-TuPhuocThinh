package _bt_lam_them_2.models;

public class NguoiNN extends Person {
    private String quocTich;

    public NguoiNN() {
    }

    public NguoiNN(String idPerson, String name) {
        super(idPerson, name);
    }

    public NguoiNN(String quocTich) {
        this.quocTich = quocTich;
    }

    public NguoiNN(String idPerson, String name, String quocTich) {
        super(idPerson, name);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "NguoiNN{" + "idPerson='" + getIdPerson() + ", name='" + getName() + "quocTich='" + quocTich + '}';
    }

    public String getInfoNN() {
        return getIdPerson() + "," + getName() + ","  + quocTich;
    }
}
