package Fraction;

import java.util.Scanner;

public class Fraction {
    static Scanner scanner = new Scanner(System.in);
    int numerator;
    int denominator;


    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            System.out.println("Denominator cannot be zero. Setting denominator to 1.");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        reduceFraction();
    }

    public void input() {
        System.out.print("Enter the numerator: ");
        this.numerator = scanner.nextInt();
        do {
            System.out.print("Enter the denominator (cannot be zero): ");
            this.denominator = scanner.nextInt();
            if (this.denominator == 0) {
                System.out.println("Denominator cannot be zero. Please enter a valid denominator.");
            }
        } while (this.denominator == 0);
        reduceFraction();
    }

    public void reduceFraction() {
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public void display() {
        reduceFraction();
        if (denominator == 1) {
            System.out.println(numerator);
        } else if (denominator == -1) {
            System.out.println(-numerator);
        } else {
            System.out.println("The fraction is: " + numerator + "/" + denominator);
        }
    }

    public Fraction plus(Fraction fraction2) {
        return new Fraction(numerator * fraction2.denominator + fraction2.numerator * denominator, denominator * fraction2.denominator);
    }

    public Fraction minus(Fraction fraction2) {
        return new Fraction(numerator * fraction2.denominator - fraction2.numerator * denominator, denominator * fraction2.denominator);
    }

    public Fraction multiply(Fraction fraction2) {
        return new Fraction(numerator * fraction2.numerator, denominator * fraction2.denominator);
    }

    public Fraction divide(Fraction fraction2) {
        if (fraction2.numerator == 0) {
            System.out.println("Cannot divide by zero.");
            return null;
        }
        return new Fraction(numerator * fraction2.denominator, denominator * fraction2.numerator);
    }

    public String propertiesOfFraction() {
        if (numerator == 0) {
            return "The fraction is zero.";
        }
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            return "The fraction is negative.";
        }
        return "The fraction is positive.";
    }

}
