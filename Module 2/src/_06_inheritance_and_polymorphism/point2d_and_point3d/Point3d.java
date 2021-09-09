package _06_inheritance_and_polymorphism.point2d_and_point3d;

public class Point3d extends Point2d{
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
    
}
