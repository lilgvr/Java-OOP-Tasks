package ru.gavrilenko.mathematics.block11;

public class Point implements Cloneable{
    private int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;

        if(obj.getClass() != Point.class) return false;
        Point p = (Point) obj;

        return p.x == x && p.y == y;
    }


    public int hashCode(){
        int t = x - y + 1;
        if(y != 0) t = y;

        return x * y + x + y + x % t;
    }

    protected Point clone() throws CloneNotSupportedException{
            return (Point) super.clone();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "{" + x + ';' + y + '}';
    }
}
