package ru.gavrilenko.mathematics.block10;

import ru.gavrilenko.mathematics.block11.Curve;
import ru.gavrilenko.mathematics.block11.Curveable;
import ru.gavrilenko.mathematics.block4.Point;

public class Triangle extends Figures implements Curveable {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.p1 = new Point(x1,y1);
        this.p2 = new Point(x2,y2);
        this.p3 = new Point(x3,y3);
    }

    public double getSquare() {
        int arr[] = {
                p1.getX() - p3.getX(),
                p1.getY() - p3.getY(),
                p2.getX() - p3.getX(),
                p2.getY() - p3.getY()
        };

        int d = arr[0]*arr[3] - arr[1] * arr[2];

        return Math.abs(0.5 * d);
    }

    public Curve getCurve() {
        return new Curve(p1,p2,p3);
    }

    public String toString() {
        return "Треугольник с координатами вершин: " + p1 + ", " + p2 + ", "+ p3;
    }
}
