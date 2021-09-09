package _06_inheritance_and_polymorphism.exercise.point2d_and_point3d;

import _06_inheritance_and_polymorphism.exercise.point2d_and_point3d.Point2d;

public class Point3d extends Point2d {
    private float z = 0.0f;

    public Point3d() {
    }

    public Point3d(float z) {
        this.z = z;
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr3d = new float[3];
        arr3d[0] = super.getX();
        arr3d[1] = super.getY();
        arr3d[2] = z;
        return arr3d;
    }

    @Override
    public String toString() {
        return "Point3d{" +
                "z=" + z +
                "get X,Y,Z=" + getXYZ()[0] + getXYZ()[1] + getXYZ()[2] +
                '}';
    }
}
