package bean.employee;

public class EducationDegree {
    private int id;
    private String name;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EducationDegree(int idEdu) {
        this.id = idEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
