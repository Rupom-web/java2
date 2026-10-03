
class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }
}

class Quadrilateral {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    Point getP1() {
        return p1;
    }

    Point getP2() {
        return p2;
    }

    Point getP3() {
        return p3;
    }

    Point getP4() {
        return p4;
    }
}

class Trapezoid extends Quadrilateral {
    private double base1;
    private double base2;
    private double height;

    Trapezoid(Point p1, Point p2, Point p3, Point p4,
              double base1, double base2, double height) {

        super(p1, p2, p3, p4);

        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    double area() {
        return (base1 + base2) * height / 2;
    }
}

class Parallelogram extends Trapezoid {
    private double b;
    private double h;

    Parallelogram(Point p1, Point p2, Point p3, Point p4,
                   double b, double h) {

        super(p1, p2, p3, p4,b,b,h);

        this.b = b;
        this.h = h;
    }

    @Override
    double area() {
        return b * h;
    }
}

class Rectangle extends Parallelogram {
    private double length;
    private double width;

    Rectangle(Point p1, Point p2, Point p3, Point p4,
              double length, double width) {

        super(p1, p2, p3, p4, length, width);

        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Square extends Rectangle {
    private double side;

    Square(Point p1, Point p2, Point p3, Point p4, double side) {

        super(p1, p2, p3, p4, side, side);

        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}

public class sorna {

    public static void main(String[] args) {

        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(0, 3);

        Trapezoid trapezoid =
                new Trapezoid(p1, p2, p3, p4, 4, 3, 3);

        Parallelogram parallelogram =
                new Parallelogram(p1, p2, p3, p4, 4, 3);

        Rectangle rectangle =
                new Rectangle(p1, p2, p3, p4, 4, 3);

        Square square =
                new Square(
                    new Point(0, 0),
                    new Point(4, 0),
                    new Point(4, 4),
                    new Point(0, 4),
                    4
                );

        System.out.println("Trapezoid Area: " + trapezoid.area());
        System.out.println("Parallelogram Area: " + parallelogram.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Square Area: " + square.area());
    }
}