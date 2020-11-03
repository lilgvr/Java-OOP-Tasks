package ru.gavrilenko.mathematics.block10;

public class Fraction extends Number implements PublicCloneable {
    private final int numerator, denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int num){
        this(num,1);
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
        return numerator + "/" + denominator;
    }

    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int intValue() {
        if(denominator == 0) throw new FractionException("Denominator == 0", new ArithmeticException("/ by zero"));
        return numerator / denominator;
    }

    public long longValue() {
        return intValue();
    }


    public float floatValue() {
        return (float) numerator/denominator;
    }


    public double doubleValue() {
        return (double) numerator/denominator;
    }
}

