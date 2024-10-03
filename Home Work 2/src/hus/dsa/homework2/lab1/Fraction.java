package hus.dsa.homework2.lab1;

import java.util.Scanner;

public class Fraction {
    private float numerator; // mẫu số
    private float denominator; // tử số

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        if (c.getDenominator() == this.getDenominator()) {
            return new Fraction(this.getNumerator() + c.getNumerator(), this.getDenominator());
        } else {
            float newNumerator = this.getNumerator() * c.getDenominator() + c.getNumerator() * this.getDenominator();
            float newDenominator = this.getDenominator() * c.getDenominator();

            return shorten(new Fraction(newNumerator, newDenominator));
        }
    }

    public Fraction shorten() {
        float newNumerator = this.getNumerator();
        float newDenominator = this.getDenominator();

        for (int i = 1; i < getNumerator(); i++) {
            if (newNumerator % i == 0 && newDenominator % i == 0) {
                int j = i;

                if (j == 1) {
                    continue;
                }

                while (newNumerator % j == 0 && newDenominator % j == 0) {
                    newNumerator /= j;
                    newDenominator /= j;
                }
            }
        }
        this.setNumerator(newNumerator);
        this.setDenominator(newDenominator);

        return this;
    }

    public Fraction shorten(Fraction c) {
        float newNumerator = c.getNumerator();
        float newDenominator = c.getDenominator();

        for (int i = 1; i < c.getNumerator(); i++) {
            if (newNumerator % i == 0 && newDenominator % i == 0) {
                int j = i;

                if (j == 1) {
                    continue;
                }

                while (newNumerator % j == 0 && newDenominator % j == 0) {
                    newNumerator /= j;
                    newDenominator /= j;
                }
            }
        }

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(Fraction c) {
        if (c.getDenominator() == this.getDenominator()) {
            return new Fraction(this.getNumerator() - c.getNumerator(), this.getDenominator());
        } else {
            float newNumerator = this.getNumerator() * c.getDenominator() - c.getNumerator() * this.getDenominator();
            float newDenominator = this.getDenominator() * c.getDenominator();

            return shorten(new Fraction(newNumerator, newDenominator));
        }
    }

    public Fraction multi(Fraction c) {
        return shorten(new Fraction(this.getNumerator() * c.getNumerator(), this.getDenominator() * c.getDenominator()));
    }

    public Fraction divide(Fraction c) {
        return shorten(this.multi(new Fraction(c.getDenominator(), c.getNumerator())));
    }

    public float getNumerator() {
        return numerator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        String string = numerator + " / " + denominator;
        return string;
    }

    public static void main(String[] args) {

        System.out.println("Enter length of Array");
        int lengthOfArray = new Scanner(System.in).nextInt();

        int min = 1;
        int max = (int) Math.pow(5, 2);
        int range = max - min + 1;
        Fraction[] array = new Fraction[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = new Fraction((int) (Math.random() * range) + min
                    , (int) (Math.random() * range) + min);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].shorten() + "\t");
        }
        System.out.println();

        Fraction sum = array[0];

        for (int i = 1; i < array.length; i++) {
            sum = sum.add(array[i]);
        }

        System.out.println(sum);

        Fraction minus = array[0];

        for (int i = 1; i < array.length; i++) {
            minus = minus.minus(array[i]);
        }

        System.out.println(minus);

        Fraction multi = array[0];

        for (int i = 1; i < array.length; i++) {
            multi = multi.multi(array[i]);
        }

        System.out.println(multi);

        Fraction divide = array[0];

        for (int i = 1; i < array.length; i++) {
            divide = divide.divide(array[i]);
        }

        System.out.println(divide);
    }
}
