package _s17_io_binary_file.exercise;

import java.io.Serializable;

public class Product  {
    private int idPro;
    private String namePro;
    private String hangPro;
    private double pricePro;
    private String info;

    public Product() {
    }

    public Product(int idPro, String namePro, String hangPro, double pricePro, String info) {
        this.idPro = idPro;
        this.namePro = namePro;
        this.hangPro = hangPro;
        this.pricePro = pricePro;
        this.info = info;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public String getHangPro() {
        return hangPro;
    }

    public void setHangPro(String hangPro) {
        this.hangPro = hangPro;
    }

    public double getPricePro() {
        return pricePro;
    }

    public void setPricePro(double pricePro) {
        this.pricePro = pricePro;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idPro=" + idPro +
                ", namePro='" + namePro +
                ", hangPro='" + hangPro +
                ", pricePro=" + pricePro +
                ", info='" + info +
                '}';
    }
}
