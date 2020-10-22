package ru.gavrilenko.mathematics.block10.points;

public class Point3D extends Point{
    protected int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString(){
        return "{" + x + ';' + y + ';' + z + '}';
    }
}
