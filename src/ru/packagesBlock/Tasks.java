package ru.packagesBlock;

import ru.gavrilenko.mathematics.block10.Fraction;
import ru.gavrilenko.mathematics.block11.Maths;
import ru.gavrilenko.mathematics.block11.Point;

import java.math.BigInteger;

public class Tasks {
    public static void main(String[] args) {

        System.out.println("#12.3\n");

        Fraction f = new Fraction(7,11);
        BigInteger bi = new BigInteger("12345678912345678912");

        System.out.println(Maths.sum(7,f,3.21));
        System.out.println(Maths.sum(7,f,3.21, bi));


        System.out.println("#12.4\n");

        System.out.println(Maths.pow(args));


        System.out.println("12.5");

        Point p = new Point(2,3);
        java.awt.Point p2 = new java.awt.Point(5,4);

        System.out.println(p);
        System.out.println(p2);

    }

}
