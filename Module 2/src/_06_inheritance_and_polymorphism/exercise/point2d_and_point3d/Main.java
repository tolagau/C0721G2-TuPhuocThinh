package _06_inheritance_and_polymorphism.exercise.point2d_and_point3d;

public class Main {
    public static void main(String[] args) {
        Point2d point2d = new Point2d();
        System.out.println(point2d);
        point2d= new Point2d(2,3);
        System.out.println(point2d);
        Point3d point3d = new Point3d();
        System.out.println(point3d);
        point3d = new Point3d(6,7,8);
        System.out.println(point3d);
    }
}
