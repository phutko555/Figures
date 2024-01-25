package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }
}

abstract class Figure {
    public abstract double area();

    public abstract String pointsToString();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
}

class Triangle extends Figure {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return 0.5 * Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())));
    }

    @Override
    public String pointsToString() {
        return String.format("%s%s%s", a, b, c);
    }

    @Override
    public Point leftmostPoint() {
        return Arrays.asList(a, b, c).stream().min((p1, p2) -> Double.compare(p1.getX(), p2.getX())).orElse(null);
    }
}

class Quadrilateral extends Figure {
    private Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);
        return triangle1.area() + triangle2.area();
    }

    @Override
    public String pointsToString() {
        return String.format("%s%s%s%s", a, b, c, d);
    }

    @Override
    public Point leftmostPoint() {
        return Arrays.asList(a, b, c, d).stream().min((p1, p2) -> Double.compare(p1.getX(), p2.getX())).orElse(null);
    }
}

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return center;
    }
}

public class Main {
    public static void main(String[] args) {
        double area1 = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
        System.out.println(area1);

        double area2 = new Quadrilateral(new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 1)).area();
        System.out.println(area2);

        double area3 = new Circle(new Point(1, 1), 3).area();
        System.out.println(area3);
    }
}
