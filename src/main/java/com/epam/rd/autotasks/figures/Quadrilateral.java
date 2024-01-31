package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point[] vertices;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.vertices = new Point[]{a, b, c, d};
    }

    @Override
    public double area() {
        // Split the quadrilateral into two triangles using diagonal AC (vertices[0] and vertices[2])
        Triangle triangle1 = new Triangle(vertices[0], vertices[1], vertices[2]);
        Triangle triangle2 = new Triangle(vertices[0], vertices[2], vertices[3]);

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
    protected Point[] getVertices() {
        return new Point[0];
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral[%s]", pointsToString());
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
