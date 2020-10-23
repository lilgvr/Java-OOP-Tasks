package ru.gavrilenko.mathematics.block10;

import ru.gavrilenko.mathematics.block11.Curve;
import ru.gavrilenko.mathematics.block11.Curveable;
import ru.gavrilenko.mathematics.block4.Point;

public class Rectangle extends Figures implements Curveable {
    private Point start;
    private int a,b;

    public Rectangle(Point start, int a, int b){
        this.start = start;
        if(a <= 0 || b <= 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    public Rectangle(int x, int y, int a, int b){
        this.start = new Point(x,y);

        if(a*b <= 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    public Curve getCurve() {
        Point[] arr = new Point[4];
        arr[0] = start;
        arr[1] = new Point(start.getX() + a, start.getY());
        arr[2] = new Point(start.getX() + a, start.getY() - b);
        arr[3] = new Point(start.getX(), start.getY() - b);

        return new Curve(arr);
    }

    public double getSquare() {
        return a*b;
    }

    public String toString() {
        return "Прямоугольник со сторонами " + a + ", " + b + ". Начало в точке " + start;
    }

}
