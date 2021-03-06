package ru.gavrilenko.mathematics.block10;

import ru.gavrilenko.mathematics.block11.Curveable;
import ru.gavrilenko.mathematics.block11.Point;
import ru.gavrilenko.mathematics.block11.Curve;

public class Quadrate extends Figures implements Curveable {
    private Point start;
    private int a;

    public Quadrate(Point start, int a){
        if(a <= 0) throw new IllegalArgumentException("Сторона не может быть <= 0");
        this.start = start;
        this.a = a;
    }

    public Quadrate(int x, int y, int a){
        this(new Point(x,y), a);
    }

    public Curve getCurve(){
        Point[] points = new Point[4];

        points[0] = start;
        points[1] = new Point(points[0].getX() + a, points[0].getY());
        points[2] = new Point(points[0].getX() + a, points[0].getY() - a);
        points[3] = new Point(points[0].getX(), points[0].getY() - a);

        return new Curve(points);
    }

    public void setA(int a){
        if(a <= 0) throw new IllegalArgumentException("Сторона не может быть <= 0");
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public double getSquare(){
        return a*a;
    }

    public String toString(){
        return "Квадрат в точке " + start + " со стороной " + a;
    }
}
