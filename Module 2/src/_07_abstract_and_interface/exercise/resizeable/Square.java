package _07_abstract_and_interface.exercise.resizeable;

public class Square extends Rectangle implements IResizeable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    public void resize(double percent) {
        setSide(getLength() * (1 + percent / 100));
        setSide(getWidth() * (1 + percent / 100));
    }
}