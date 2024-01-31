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
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return String.format("(%s,%s)", center.getX(), center.getY());
    }

    @Override
    public String toString() {
        return String.format("%s%s", pointsToString(), radius);
    }

    @Override
    public Point leftmostPoint() {
        return center;
    }
}

