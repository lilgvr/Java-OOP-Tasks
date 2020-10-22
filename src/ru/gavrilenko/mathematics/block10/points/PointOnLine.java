package ru.gavrilenko.mathematics.block10.points;

import ru.gavrilenko.mathematics.block6.Line;

public class PointOnLine extends Point{
    protected Line line;

    public PointOnLine(int x, int y, Line line) {
        super(x, y);
        this.line = line;
    }

    public String toString(){
        return "{" + x + ';' + y + "} на прямой " + line;
    }
}
