package _04_oop_java.exercise.class_fan;

public class ClassFan {
    public static final int SLOW = 1;
   public static final int MEDIUM = 2;
   public static final int FAST = 3;
    int speed = SLOW;
    boolean onOf = false;
    double radius = 5;
    String color = "blue";

    public ClassFan(int speed, boolean onOf, double radius, String color) {
        this.speed = speed;
        this.onOf = onOf;
        this.radius = radius;
        this.color = color;
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOnOf() {
        return onOf;
    }

    public void setOnOf(boolean onOf) {
        this.onOf = onOf;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (onOf) {
            return "ClassFan{" +
                    " speed=" + speed +
                    ", radius=" + radius +
                    ", fan is on" +
                    ", color='" + color + '\'' +
                    '}';
        } else return "ClassFan{" +
                ", fan is off" +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
