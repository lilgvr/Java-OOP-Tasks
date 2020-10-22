package ru.gavrilenko.mathematics.block11;

import ru.gavrilenko.mathematics.block10.Fraction;

public class Maths {
    public static double sum(Number ...arr){
        double res = 0;

        for(Number i : arr){
            res += i.doubleValue();
        }

        return res;
    }

    public static double pow(String[] arr){
        if(arr.length == 0) throw new IllegalArgumentException();

        int a = Integer.parseInt(arr[0]),
            b = Integer.parseInt(arr[1]);

        return Math.pow(a,b);
    }

}
