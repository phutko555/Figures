package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure {
    private Point[] vertices;

    public Triangle(Point a, Point b, Point c) {
        this.vertices = new Point[]{a, b, c};
    }

    @Override
    public double area() {
      
        double area = 0.5 * Math.abs(
                vertices[0].getX() * (vertices[1].getY() - vertices[2].getY()) +
                vertices[1].getX() * (vertices[2].getY() - vertices[0].getY()) +
                vertices[2].getX() * (vertices[0].getY() - vertices[1].getY())
        );
        return area;
    }

    @Override
    public String pointsToString() {
     
        StringBuilder sb = new StringBuilder();
        for (Point vertex : vertices) {
            sb.append(String.format("(%s,%s)", vertex.getX(), vertex.getY()));
        }
        return sb.toString();
    }

    @Override
    public Point leftmostPoint() {
      
        return Arrays.stream(vertices)
                .min((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                .orElse(null);
    }
}

