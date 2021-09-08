package _05_access_modifier.exercise.student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Thịnh");
       student.setClasses("07G2");
        System.out.printf(student.getName()+"\n");
        System.out.printf(student.getClasses());

    }
}
