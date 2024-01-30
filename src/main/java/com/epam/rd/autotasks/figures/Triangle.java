package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        // Using the formula for the area of a triangle with three vertices
        return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        // Return the leftmost point based on X coordinate
        Point[] points = {a, b, c};
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.getX(), p2.getX()));
        return points[0];
    }
}
