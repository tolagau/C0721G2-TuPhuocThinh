package _06_inheritance_and_polymorphism.exercise.circle_and_cylinder;

public class Circle {
    public double radius = 1.0;
    public String color = "red";
    public double area =0.0;

    public Circle() {
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        this.area = this.radius * this.radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = this.radius * this.radius * Math.PI;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ",Area=" + getArea() +
                '}';
    }
}
