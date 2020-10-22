package ru.gavrilenko.mathematics.block6;

import ru.gavrilenko.mathematics.block4.Point;

public class Line {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public Line(int x1, int y1, int x2, int y2){
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }


    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setStartCoords(int x, int y){
        this.start = new Point(x,y);
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setEndCoords(int x, int y){
        this.end = new Point(x,y);
    }

    public String toString(){
        return "Линия: " + start + " -> " + end;
    }
}
