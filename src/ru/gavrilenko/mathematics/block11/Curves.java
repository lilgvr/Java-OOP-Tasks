package ru.gavrilenko.mathematics.block11;

public class Curves {
    public static Curve getAllCurves(Curveable ...arr){
        Curve res = new Curve();

        for(Curveable i : arr){
            res.addPoints(i.getCurve().getPoints());
        }

        return res;
    }
}
