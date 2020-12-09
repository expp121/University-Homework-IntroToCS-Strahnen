package ObjectOrientedProgramming.EX2;

public class Vector3D {
    double x;
    double y;
    double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double length() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D mult(double factor) {
        return new Vector3D(this.x * factor, this.y * factor, this.z * factor);
    }

    public String toString() {
        return ("x = " + this.x + "\ny = " + this.y + "\nz = " + this.z);
    }

}
