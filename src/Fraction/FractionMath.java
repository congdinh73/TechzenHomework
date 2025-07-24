package Fraction;

import java.util.ArrayList;
import java.util.Scanner;

public class FractionMath {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraction fraction1 = new Fraction(1, 1);
        Fraction fraction2 = new Fraction(1, 1);

        System.out.println("Enter the first fraction");
        fraction1.input();
        System.out.println("Enter the second fraction");
        fraction2.input();

        System.out.println("============================");
        System.out.println("Reduced form of the first fraction: ");
        fraction1.display();
        System.out.println("Reduced form of the second fraction: ");
        fraction2.display();

        System.out.println("============================");
        System.out.println("Plus operation: ");
        fraction1.plus(fraction2).display();
        System.out.println("Minus operation: ");
        fraction1.minus(fraction2).display();
        System.out.println("Multiply operation: ");
        fraction1.multiply(fraction2).display();
        System.out.println("Divide operation: ");
        if (fraction2.numerator == 0) {
            System.out.println("Cannot divide by zero.");
        } else {
            fraction1.divide(fraction2).display();
        }

        System.out.println("============================");
        System.out.println("Properties of the first fraction: " + fraction1.propertiesOfFraction());
        System.out.println("Properties of the second fraction: " + fraction2.propertiesOfFraction());

    }
}
