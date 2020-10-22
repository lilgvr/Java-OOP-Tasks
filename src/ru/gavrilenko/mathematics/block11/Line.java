package ru.gavrilenko.mathematics.block11;

public class Line implements Lengthable, Cloneable{
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2){
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        Line l = (Line) obj;

        if(obj.getClass() != Line.class) return false;
        if(l.start == null || l.end == null) return false;

        return l.start.equals(start) && l.end.equals(end);
    }

    public int hashCode(){
        return (start == null || end == null)? -1 : start.hashCode() * end.hashCode();
    }

    protected Line clone() throws CloneNotSupportedException{
        Line clone = (Line) super.clone();
        Point start = this.start.clone();
        Point end = this.end.clone();

        return new Line(start, end);
    }

    public double getLength() {
        double res;
        res = Math.sqrt(
                Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2)
        );

        return res;
    }
}
