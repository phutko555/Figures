package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        // Using the formula for the area of a circle
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        // For a circle, any point on the circumference can be considered
        return new Point(center.getX() - radius, center.getY());
    }
}
