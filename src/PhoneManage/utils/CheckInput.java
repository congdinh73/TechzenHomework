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
            System.out.print("Please enter a positive integer: ");
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Input must be a positive integer greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }
    }
}
