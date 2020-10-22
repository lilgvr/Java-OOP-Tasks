package ru.gavrilenko.mathematics.block5;

import ru.gavrilenko.mathematics.block4.Point;

public class Line {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2){
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public int getLength(){
        int res;
        res = (int)Math.sqrt(
                Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2)
        );

        return res;
    }
}
