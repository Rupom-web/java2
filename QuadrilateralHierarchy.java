class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
}

// Quadrilateral is the superclass -- holds the 4 corner points privately.
// The area formula (Shoelace formula) is generic enough to work for ANY
// simple quadrilateral, so every subclass can reuse it via inheritance.
class Quadrilateral {
    private Point p1, p2, p3, p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
    }

    // Shoelace formula for a 4-point polygon
    protected double calculateArea() {
        double sum = (p1.getX() * p2.getY() - p2.getX() * p1.getY())
                   + (p2.getX() * p3.getY() - p3.getX() * p2.getY())
                   + (p3.getX() * p4.getY() - p4.getX() * p3.getY())
                   + (p4.getX() * p1.getY() - p1.getX() * p4.getY());
        return Math.abs(sum) / 2.0;
    }
}

// Trapezoid: a quadrilateral with (at least) one pair of parallel sides.
// No extra fields needed -- the generic area formula already works.
class Trapezoid extends Quadrilateral {
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
}

// Parallelogram: both pairs of opposite sides are parallel. Still reuses
// the same area calculation, since it's a special case of a trapezoid.
class Parallelogram extends Trapezoid {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
}

// Rectangle: a parallelogram with all right angles.
class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
}

// Square: a rectangle with all sides equal.
class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
}

public class QuadrilateralHierarchy {
    public static void main(String[] args) {
        // Using the shoelace formula, this trapezoid's true area works out to 16.00
        // (parallel sides of length 6 and 2, height 4: (6+2)/2 * 4 = 16).
        // If your assignment sheet expects 24.00 for this exact input, that figure
        // appears to be a typo in the original document -- 16.00 is the correct area.
        Trapezoid t = new Trapezoid(new Point(0, 0), new Point(6, 0), new Point(4, 4), new Point(2, 4));
        Parallelogram pg = new Parallelogram(new Point(0, 0), new Point(5, 0), new Point(7, 4), new Point(2, 4));
        Rectangle r = new Rectangle(new Point(0, 0), new Point(6, 0), new Point(6, 2), new Point(0, 2));
        Square s = new Square(new Point(0, 0), new Point(2, 0), new Point(2, 2), new Point(0, 2));

        System.out.printf("Trapezoid Area: %.2f%n", t.calculateArea());
        System.out.printf("Parallelogram Area: %.2f%n", pg.calculateArea());
        System.out.printf("Rectangle Area: %.2f%n", r.calculateArea());
        System.out.printf("Square Area: %.2f%n", s.calculateArea());
    }
}