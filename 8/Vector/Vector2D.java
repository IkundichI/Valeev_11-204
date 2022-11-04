package Vector;


public class Vector2D {
    private double coordinateX;
    private double coordinateY;
    public void printVector() {
        System.out.println("Coordinate X -> " + coordinateX + ", coordinate Y -> " + coordinateY);
    }
    public Vector2D() {
        coordinateX = 0d;
        coordinateY = 0d;
    }
    public Vector2D(double coordinateX, double coordinateY) {
        this.coordinateY = coordinateY;
        this.coordinateX = coordinateX;
    }
    public Vector2D add(Vector2D vector1) {
        Vector2D vector2 = new Vector2D(vector1.getCoordinateX() + coordinateX, vector1.getCoordinateY() + coordinateY);
        return vector2;
    }
    public Vector2D sub(Vector2D vector1) {
        Vector2D vector2 = new Vector2D(coordinateX - vector1.coordinateX, coordinateY - vector1.coordinateY);
        return vector2;
    }
    public Vector2D mult(double k) {
        Vector2D vector2 = new Vector2D(coordinateX * k, coordinateY * k);
        return vector2;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    @Override
    public String toString() {
        return ("Coordinate X -> " + coordinateX + ", coordinate Y -> " + coordinateY);
    }

    public void add2(Vector2D vector1) {
        coordinateY += vector1.getCoordinateY();
        coordinateX += vector1.getCoordinateX();
    }
    public void sub2(Vector2D vector1) {
        coordinateY -= vector1.getCoordinateY();
        coordinateX -= vector1.getCoordinateX();
    }
    public void mult2(double k) {
        coordinateY *= k;
        coordinateX *= k;
    }

    public double length() {
        return Math.sqrt(coordinateX*coordinateX + coordinateY*coordinateY);
    }
    public double scalarProduct(Vector2D vector1) {
        return vector1.coordinateY*coordinateY + coordinateX*vector1.coordinateX;
    }
    public double cos(Vector2D vector1) {
        return (scalarProduct(vector1)) / (length()*vector1.length());
    }
    public boolean equals(Vector2D vector1) {
        if (vector1.coordinateX == coordinateX && vector1.coordinateY == coordinateY) {
            return true;
        }
        return false;
    }
}
