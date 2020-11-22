package practic.univer;

import ru.gavrilenko.mathematics.block10.FractionException;

public class Fraction<E extends Number> extends Number implements Comparable <Fraction <E>> {
    private Number numerator, denominator;

    public Fraction(E numerator, E denominator) {
        if (denominator.doubleValue() == 0)
            throw new FractionException("Denominator == 0", new ArithmeticException("/ by zero"));

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(E numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction <Double> sum(Fraction <?> n) {
        double gcd;
        if (!denominator.equals(n.denominator))
            gcd = denominator.doubleValue() * n.denominator.doubleValue() / lcm(denominator.doubleValue(), n.denominator.doubleValue());
        else
            gcd = denominator.doubleValue();

        double d1 = numerator.doubleValue() * (gcd / denominator.doubleValue());
        double d2 = n.numerator.doubleValue() * (gcd / n.denominator.doubleValue());

        return new Fraction <>(d1 + d2, gcd);
    }

    public Fraction <Double> dif(Fraction <?> n) {
        double gcd;

        if (!denominator.equals(n.denominator))
            gcd = denominator.doubleValue() * n.denominator.doubleValue() / lcm(denominator.doubleValue(), n.denominator.doubleValue());
        else
            gcd = denominator.doubleValue();

        double d1 = numerator.doubleValue() * (gcd / denominator.doubleValue());
        double d2 = n.numerator.doubleValue() * (gcd / n.denominator.doubleValue());
        return new Fraction <>(d1 - d2, gcd);
    }

    public Fraction <Double> mult(Fraction <?> n) {
        double num, den;
        num = numerator.doubleValue() * n.numerator.doubleValue();
        den = denominator.doubleValue() * n.denominator.doubleValue();

        return new Fraction <>(num, den);
    }

    public Fraction <Double> div(Fraction <?> n) {
        double num, den;
        num = numerator.doubleValue() * n.denominator.doubleValue();
        den = denominator.doubleValue() * n.numerator.doubleValue();

        return new Fraction <>(num, den);
    }

    private double lcm(double a, double b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return Math.abs(a);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != Fraction.class) return false;

        Fraction <E> fr = (Fraction <E>) obj;

        return fr.numerator.equals(numerator) && fr.denominator.equals(denominator);
    }

    public int hashCode() {
        return intValue() + numerator.intValue() + denominator.intValue();
    }

    public Fraction <E> clone() {
        try {
            return (Fraction <E>) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    public long longValue() {
        return intValue();
    }

    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public int compareTo(Fraction <E> o) {
        return Double.compare(this.doubleValue(), o.doubleValue());
    }

    public String toString() {
        if (numerator.intValue() == numerator.doubleValue() && denominator.intValue() == denominator.doubleValue())
            return numerator.intValue() + "/" + denominator.intValue();

        if (numerator.equals(denominator)) return "" + numerator;
        return numerator + "/" + denominator;
    }
}
