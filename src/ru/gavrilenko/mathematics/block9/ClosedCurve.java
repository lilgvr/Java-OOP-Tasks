package ru.gavrilenko.mathematics.block9;

import ru.gavrilenko.mathematics.block4.Point;
import ru.gavrilenko.mathematics.block5.Curve;

import java.util.ArrayList;

public class ClosedCurve extends Curve {
    private ArrayList<Point> points = new ArrayList<>();

    public ClosedCurve(Point... pts) {
        super(pts);

        for(Point i : pts){
            this.points.add(i);
        }

        if(this.points.size() > 2){
            if(!pts[0].equals(pts[pts.length - 1])){
                this.points.add(pts[0]);
            }
        }
    }

    public String toString(){
        String s = "Замкнутая ломаная: [";
        for(int i = 0; i < points.size(); i++){
            if(i == points.size() - 1) s += points.get(i).toString() + "]";
            else s += points.get(i).toString() + ", ";
        }

        return s;
    }


}
