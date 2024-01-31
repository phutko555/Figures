package com.epam.rd.autotasks.figures;

import java.util.Arrays;

abstract class Figure {

    public abstract double area();

    public abstract Point leftmostPoint();

    public String pointsToString() {
        Point[] points = getVertices();
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    protected abstract Point[] getVertices();

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), pointsToString());
    }
}
