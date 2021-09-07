package _04_oop_java.exercise.quadratic_equation;

public class QuadraticEquation {
    double a;
    double b;
    double c;
    double delta;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getDiscriminant() {
        return delta = b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(delta)) / (2 * a);

    }
}
