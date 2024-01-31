package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point[] vertices;

    public Triangle(Point a, Point b, Point c) {
        this.vertices = new Point[]{a, b, c};
    }

    @Override
    public double area() {
        double x1 = vertices[0].getX();
        double y1 = vertices[0].getY();
        double x2 = vertices[1].getX();
        double y2 = vertices[1].getY();
        double x3 = vertices[2].getX();
        double y3 = vertices[2].getY();

        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
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
    protected Point[] getVertices() {
        return new Point[0];
    }

    @Override
    public String toString() {
        return String.format("Triangle[%s]", pointsToString());
    }

    @Override
    public Point leftmostPoint() {
        Point leftmost = vertices[0];
        for (Point vertex : vertices) {
            if (vertex.getX() < leftmost.getX()) {
                leftmost = vertex;
            }
        }
        return leftmost;
    }
}
