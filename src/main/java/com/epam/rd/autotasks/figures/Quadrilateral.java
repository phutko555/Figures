package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Quadrilateral extends Figure {
    private Point[] vertices;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.vertices = new Point[]{a, b, c, d};
    }

    @Override
    public double area() {

        Triangle triangle1 = new Triangle(vertices[0], vertices[1], vertices[3]);
        Triangle triangle2 = new Triangle(vertices[1], vertices[2], vertices[3]);
        return triangle1.area() + triangle2.area();
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


