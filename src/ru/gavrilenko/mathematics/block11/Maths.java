package ru.gavrilenko.mathematics.block11;

import ru.gavrilenko.mathematics.block10.Fraction;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Maths {
    public static double sum(Number ...arr){
        double res = 0;

        for(Number i : arr){
            res += i.doubleValue();
        }

        return res;
    }

    public static double power(String[] arr){
        if(arr.length == 0) throw new IllegalArgumentException();

        int a = parseInt(arr[0]),
            b = parseInt(arr[1]);

        return pow(a,b);
    }

}
