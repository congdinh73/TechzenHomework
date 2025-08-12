package PhoneManage.utils;

import java.util.Scanner;

public class CheckInput {
    static Scanner scanner = new Scanner(System.in);

    public static String readString() {
        String input;
        while (true) {
            try {
                input = scanner.nextLine();
               if (!input.isBlank()) {
                   return input;
               } else {
                   System.out.println("Input cannot be empty. Please try again.");
               }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }

    public static int readPositiveInteger() {
        int number;
        while (true) {
            try {
                System.out.println("Please enter a positive integer: ");
                number = scanner.nextInt();
                if (number > 0) {
                    scanner.nextLine();
                    return number;
                } else {
                    System.out.println("Please enter a positive integer. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
