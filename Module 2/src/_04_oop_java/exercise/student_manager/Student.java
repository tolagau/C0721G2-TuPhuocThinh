package _04_oop_java.exercise.student_manager;

public class Student {
    String name;
    int age;
    String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvg() {
        return age;
    }

    public void setAvg(int avg) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Student(String name, int age, String addr){

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", avg=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
