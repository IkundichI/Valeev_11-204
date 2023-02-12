package First;

public class Rectangle {
    double x1; //Левая верхняя
    double y1;
    double x2; //Правая верхняя
    double y2;
    double x3; //Левая нижняя
    double y3;
    double x4; //Правая нижняя
    double y4;

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public double square() {
        double a = Math.abs(x2 - x1);
        double b = Math.abs(y1 - y3);
        return a*b;
    }
    public double perimeter() {
        double a = Math.abs(x2 - x1);
        double b = Math.abs(y1 - y3);
        return 2*a + 2*b;
    }
    public boolean commonPoints(Rectangle rectangle) {
        if (((x2 >= rectangle.x3) && (y2 >= rectangle.y2)) && ((rectangle.x2 >= x2) && (rectangle.y2 >= y2))) {
            return true;
        }
        if (((x3 >= rectangle.x3) && (y3 >= rectangle.y3)) && (rectangle.x2 >= x3) && (rectangle.y2 >= y3)) {
            return true;
        }
        if (((x1 <= rectangle.x1) && (y1 >= rectangle.y1)) && (x4 >= rectangle.x1) && (y4 <= rectangle.x1)) {
            return true;
        }
        if (((x1 <= rectangle.x4) && (y1 >= rectangle.y4)) && (x4 >= rectangle.x4) && (y4 <= rectangle.y4)) {
            return true;
        }
        return false;

    }
    public boolean equals(Rectangle rectangle) {
        if (rectangle.x1 == x1 && rectangle.x2 == x2 && rectangle.x3 == x3 && rectangle.x4 == x4 && rectangle.y1 == y1 && rectangle.y2 == y2 && rectangle.y3 == y3 && rectangle.y4 == y4) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", x4=" + x4 +
                ", y4=" + y4 +
                '}';
    }
}
