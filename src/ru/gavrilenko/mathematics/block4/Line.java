package ru.gavrilenko.mathematics.block4;

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

    public String toString(){
        return "Прямая. Начало: " + start + ". Конец: " + end;
    }
}
