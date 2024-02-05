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
        
        return String.format("(%s,%s)", center.getX(), center.getY());
    }

    @Override
    public Point leftmostPoint() {
        
        return center;
    }
}

