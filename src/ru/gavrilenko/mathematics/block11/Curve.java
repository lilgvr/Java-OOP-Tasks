package ru.gavrilenko.mathematics.block11;

import ru.gavrilenko.mathematics.block4.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Curve implements Lengthable, Curveable{
    private ArrayList<Point> points = new ArrayList<>();

    public Curve(){}

    public Curve(Point ...points){
        this.points.addAll(Arrays.asList(points));
    }

    public Curve(ArrayList<Point> points){
        this.points.addAll(points);
    }

    public void addPoints(Point ...pts){
        this.points.addAll(Arrays.asList(pts));
    }

    public ArrayList<Point> getPoints(){
        return new ArrayList <>(points);
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
        return new Curve(points);
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[");

        for(int i = 0; i < points.size(); i++){
            if(i == points.size() - 1) s.append(points.get(i).toString()).append("]");
            else s.append(points.get(i).toString()).append(", ");
        }

        return s.toString();
    }

}
