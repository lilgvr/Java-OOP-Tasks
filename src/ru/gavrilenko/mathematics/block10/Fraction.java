package ru.gavrilenko.mathematics.block10;

public class Fraction extends Number{
    private final int numerator, denominator;

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

    private static Fraction reduce(Fraction n){
        int[] res = new int[2];
        int num = n.numerator, den = n.denominator;

        if(den == 0){
            return n;
        }

        if(num > den){
            if(num % den == 0){
                res[0] = num/den;
                res[1] = 1;
            }else{
                res[0] = num / lcm(num, den);
                res[1] = den / lcm(num, den);
            }
        }else{
            if(den % num == 0){
                res[0] = num / lcm(num, den);
                res[1] = den/num;
            }
        }

        return new Fraction(res[0], res[1]);
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;

        if(obj.getClass() != Fraction.class) return false;
        Fraction fr = (Fraction) obj;

        return fr.numerator == numerator && fr.denominator == denominator;
    }

    public int hashCode(){
        return intValue() + numerator + denominator;
    }

    public String toString(){
        if(numerator == denominator) return "" + numerator;
        return (denominator == 0)?
                "Знаменатель не может быть равен нулю" :
                "" + numerator + '/' + denominator;
    }


    public int intValue() {
        return numerator / denominator;
    }

    public long longValue() {
        return (long) numerator/denominator;
    }


    public float floatValue() {
        return (float) numerator/denominator;
    }


    public double doubleValue() {
        return (double) numerator/denominator;
    }
}

