package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        // Using the formula for the area of a convex quadrilateral divided into two triangles by a diagonal
        return new Triangle(a, b, c).area() + new Triangle(a, c, d).area();
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        // Return the leftmost point based on X coordinate
        Point[] points = {a, b, c, d};
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.getX(), p2.getX()));
        return points[0];
    }
}
