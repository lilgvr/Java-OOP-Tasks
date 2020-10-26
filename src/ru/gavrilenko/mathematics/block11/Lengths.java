package ru.gavrilenko.mathematics.block11;

public class Lengths {
    public static double getAllLength(Lengthable ...arr){
        double res = 0;

        for(Lengthable i : arr){
            res += i.getLength();
        }

        return res;
    }
}
