package _06_inheritance_and_polymorphism.exercise.point_and_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point.toString());
        MoveablePoint move = new MoveablePoint(5, 5);
        move.setXY(10, 13);
        System.out.println(move.getXY()[0] + " " + move.getXY()[1]);
        System.out.println(move.getSpeed()[0] + " " + move.getSpeed()[1]);
        System.out.println(move.move()[0] + " " + move.move()[1]);
        System.out.println(move.toString());
    }
}
