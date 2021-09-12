package _07_abstract_and_interface.exercise.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Square(5);
        Shape shape3 = new Rectangle(5, 10);
        Shape[] shapeList = {shape1, shape2, shape3};

        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] instanceof Circle) {
                System.out.println("Current Area is:" + ((Circle) shapeList[i]).getArea());
                ((Circle) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Circle) shapeList[i]).getArea());
            } else if (shapeList[i] instanceof Square) {
                System.out.println("Area is:" + ((Square) shapeList[i]).getArea());
                ((Square) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Square) shapeList[i]).getArea());
            } else {
                System.out.println("Area is:" + ((Rectangle) shapeList[i]).getArea());
                ((Rectangle) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Rectangle) shapeList[i]).getArea());
            }
        }
    }
}
