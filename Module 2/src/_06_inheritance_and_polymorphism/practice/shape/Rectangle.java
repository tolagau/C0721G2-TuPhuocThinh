package _06_inheritance_and_polymorphism.practice.shape;

public class Rectangle extends Shape {
    double width;
    double length;

    public Rectangle() {
    }

    public Rectangle(double width, double lengt) {
        this.width = width;
        this.length = lengt;
    }

    public Rectangle(double width, double lengt, String color, Boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = lengt;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }
}
