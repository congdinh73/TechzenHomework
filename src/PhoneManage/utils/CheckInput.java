package PhoneManage.utils;

import java.util.Scanner;

public class CheckInput {
    static Scanner scanner = new Scanner(System.in);

    public static String readString() {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

    public static int readPositiveInteger() {
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    scanner.nextLine();
                    return number;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next();
            }
        }
    }
}
