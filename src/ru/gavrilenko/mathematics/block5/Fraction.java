package ru.gavrilenko.mathematics.block5;

public class Fraction {
    private int numerator, denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction sum(Fraction n){
        int gcd;
        if(denominator != n.denominator)
            gcd = denominator*n.denominator/lcm(denominator, n.denominator);
        else
            gcd = denominator;

        int d1 = numerator*(gcd/denominator);
        int d2 = n.numerator*(gcd/n.denominator);
        return new Fraction(d1+d2, gcd);
    }

    public Fraction dif(Fraction n){
        int gcd;
        if(denominator != n.denominator)
            gcd = denominator*n.denominator/lcm(denominator, n.denominator);
        else
            gcd = denominator;

        int d1 = numerator*(gcd/denominator);
        int d2 = n.numerator*(gcd/n.denominator);
        return new Fraction(d1-d2, gcd);
    }

    public Fraction mult(Fraction n){
        int num, den;
        num = numerator * n.numerator;
        den = denominator * n.denominator;

        return new Fraction(num, den);
    }

    public Fraction div(Fraction n){
        int num, den;
        num = numerator * n.denominator;
        den = denominator * n.numerator;

        return new Fraction(num, den);
    }

    private static int lcm(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return Math.abs(a);
    }

    public String toString(){
        if(numerator == denominator) return "" + numerator;
        return (denominator == 0)?
                "Знаменатель не может быть равен нулю" :
                "" + numerator + '/' + denominator;
    }
}

