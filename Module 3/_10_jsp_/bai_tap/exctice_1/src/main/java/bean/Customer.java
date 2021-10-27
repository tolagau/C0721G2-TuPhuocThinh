package bean;

public class Customer {
    private String nameCus;
    private String dateOfBirth;
    private String addr;
    private String img;

    public Customer(String nameCus, String dateOfBirth, String addr, String img) {
        this.nameCus = nameCus;
        this.dateOfBirth = dateOfBirth;
        this.addr = addr;
        this.img = img;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

