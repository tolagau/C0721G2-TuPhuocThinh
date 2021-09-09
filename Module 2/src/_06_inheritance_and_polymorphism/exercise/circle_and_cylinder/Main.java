package _06_inheritance_and_polymorphism.exercise.circle_and_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle = new Circle(3.2,"pink");
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        cylinder = new Cylinder(10,"blue",20);
        System.out.println(cylinder);
    }
}
