package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure {
    private Point[] vertices;

    public Triangle(Point a, Point b, Point c) {
        this.vertices = new Point[]{a, b, c};
    }

    @Override
    public double area() {
        // Calculate the area of the triangle using the vertices
        double area = 0.5 * Math.abs(
                vertices[0].getX() * (vertices[1].getY() - vertices[2].getY()) +
                vertices[1].getX() * (vertices[2].getY() - vertices[0].getY()) +
                vertices[2].getX() * (vertices[0].getY() - vertices[1].getY())
        );
        return area;
    }

    @Override
    public String pointsToString() {
        // Format vertices as (a.x,a.y)(b.x,b.y)(c.x,c.y)
        StringBuilder sb = new StringBuilder();
        for (Point vertex : vertices) {
            sb.append(String.format("(%s,%s)", vertex.getX(), vertex.getY()));
        }
        return sb.toString();
    }

    @Override
    public Point leftmostPoint() {
        // Find the leftmost point among vertices
        return Arrays.stream(vertices)
                .min((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                .orElse(null);
    }
}
