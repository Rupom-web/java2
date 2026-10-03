class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}


// Base class
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
}


// Trapezoid
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

    public double area() {
        return 0.5 * (base1 + base2) * height;
    }
}


// Parallelogram
class Parallelogram extends Trapezoid {

    private double base;
    private double height;

    Parallelogram(Point p1, Point p2, Point p3, Point p4,
                  double base, double height) {

        super(p1, p2, p3, p4, base, base, height);

        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return base * height;
    }
}


// Rectangle
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
    public double area() {
        return length * width;
    }
}


// Square
class Square extends Rectangle {

    private double side;

    Square(Point p1, Point p2, Point p3, Point p4,
           double side) {

        super(p1, p2, p3, p4, side, side);

        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}


// Main class
public class shape {

    public static void main(String[] args) {

        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 3);
        Point p4 = new Point(0, 3);

        Trapezoid trapezoid = new Trapezoid(
                p1, p2, p3, p4, 10, 6, 4);

        Parallelogram parallelogram = new Parallelogram(
                p1, p2, p3, p4, 8, 5);

        Rectangle rectangle = new Rectangle(
                p1, p2, p3, p4, 8, 5);

        Square square = new Square(
                p1, p2, p3, p4, 5);

        System.out.println("Trapezoid Area = " + trapezoid.area());
        System.out.println("Parallelogram Area = " + parallelogram.area());
        System.out.println("Rectangle Area = " + rectangle.area());
        System.out.println("Square Area = " + square.area());
    }
}