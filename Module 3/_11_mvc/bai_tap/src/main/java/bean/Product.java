package bean;

public class Product {
    private Integer id;
    private String name;
    private int price;
    private String moTa;
    private String make;

    public Product() {
    }

    public Product(Integer id, String name, int price, String moTa, String make) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.moTa = moTa;
        this.make = make;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
