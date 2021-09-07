package _04_oop_java.exercise.class_fan;

public class Main {
    public static void main(String[] args) {
        ClassFan fanClass = new ClassFan(3, true, 10, "yellow");
        System.out.println(fanClass.toString());
        ClassFan fanClass1 = new ClassFan(2, false, 5, "blue");
        System.out.println(fanClass1.toString());
    }
}
