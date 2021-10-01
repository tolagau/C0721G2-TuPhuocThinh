package _s22_behavioral_design_pattern.practice.class_observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}