package _bt_lam_them_2.models;

public class Person {
    private String idPerson;
    private String name;

    public Person() {
    }

    public Person(String idPerson, String name) {
        this.idPerson = idPerson;
        this.name = name;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson='" + idPerson + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getInfo() {
        return idPerson + "," + name + ",";
    }
}
