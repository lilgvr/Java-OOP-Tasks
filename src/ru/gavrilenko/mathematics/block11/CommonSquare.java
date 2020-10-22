package ru.gavrilenko.mathematics.block11;

import ru.gavrilenko.mathematics.block10.Figures;

public class CommonSquare {
    public static double allSquare(Figures ...fig){
        double res = 0;

        for(Figures i : fig){
            res += i.getSquare();
        }

        return res;
    }
}
