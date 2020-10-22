package ru.gavrilenko.mathematics.block10.points;

public class Point3DTime extends Point3D{
    protected int t;

    public Point3DTime(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }

    public String toString(){
        return "{" + x + ';' + y + ';' + z + ';' + t + '}';
    }
}
