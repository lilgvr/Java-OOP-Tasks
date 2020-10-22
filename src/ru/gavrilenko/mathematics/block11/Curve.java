package ru.gavrilenko.mathematics.block11;

import ru.gavrilenko.mathematics.block4.Point;

import java.util.ArrayList;

public class Curve implements Lengthable, Curveable{
    private ArrayList<Point> points = new ArrayList<>();

    public Curve(){}

    public Curve(Point ...points){
        for(Point i : points){
            this.points.add(i);
        }
    }

    public void addPoints(Point ...pts){
        for(Point i : pts){
            this.points.add(i);
        }
    }

    public ArrayList<Point> getPoints(){
        return points;
    }

    public void addPoints(ArrayList<Point> points){
        this.points.addAll(points);
    }

    protected static double len(Point start, Point end){
        return Math.sqrt(Math.pow(end.getX() + start.getX(), 2) + Math.pow(end.getY() + start.getY(), 2));
    }

    public final double getLength(){
        double sum = 0;
        for(int i = 1; i < points.size(); i++){
            sum += len(points.get(i-1), points.get(i));
        }

        return Math.round(sum);
    }

    public Curve getCurve() {
        return this;
    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < points.size(); i++){
            if(i == points.size() - 1) s += points.get(i).toString() + "]";
            else s += points.get(i).toString() + ", ";
        }

        return s;
    }

}
