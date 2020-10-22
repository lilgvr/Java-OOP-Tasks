package ru.gavrilenko.mathematics.block10.points;

public class PointOnPlaneTime extends PointOnPlane{
    protected int t;

    public PointOnPlaneTime(int x, int y, int t) {
        super(x, y);
        this.t = t;
    }

    public String toString(){
        return "{" + x + ';' + y + ';' + t + '}';
    }
}
