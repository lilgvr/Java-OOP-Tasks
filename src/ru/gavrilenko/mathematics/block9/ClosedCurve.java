package ru.gavrilenko.mathematics.block9;

import ru.gavrilenko.mathematics.block11.Point;
import ru.gavrilenko.mathematics.block11.Curve;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosedCurve extends Curve {
    private ArrayList<Point> points = new ArrayList<>();

    public ClosedCurve(Point... pts) {
        super(pts);

        this.points.addAll(Arrays.asList(pts));

        if(this.points.size() > 2){
            if(!pts[0].equals(pts[pts.length - 1])){
                this.points.add(pts[0]);
            }
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder("Замкнутая ломаная: [");

        for(int i = 0; i < points.size(); i++){
            if(i == points.size() - 1) s.append(points.get(i).toString()).append("]");
            else s.append(points.get(i).toString()).append(", ");
        }

        return s.toString();
    }


}
