package Set;

import java.util.*;

public class SetHomework {
    static Scanner scanner = new Scanner(System.in);
    static Set<Integer> list = new TreeSet<>();


    public void run() {
        int choice;
        do {
            while (true) {
                showMenu();
                switch (choice = readPositiveInteger()) {
                    case 1:
                        addElements();
                        break;
                    case 2:
                        showAllElements();
                        break;
                    case 3:
                        sumAllElements();
                        break;
                    case 4:
                        findCommonElements();
                        break;
                    case 5:
                        findMinAndMaxElements();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            }
        } while (choice < 1 || choice > 6);
    }

    public static void showMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1. Add element to set");
        System.out.println("2. Show all elements in set");
        System.out.println("3. Sum all elements in set");
        System.out.println("4. Find common elements in two sets");
        System.out.println("5. Find min and max elements in set");
        System.out.println("6. Exit");
        System.out.print("Input your choice: ");
    }

    private static void addElements() {
        System.out.print("Input number of elements: ");
        int n = readPositiveInteger();
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + (i + 1) + ": ");
            int value = readPositiveInteger();
            if (list.contains(value)) {
                System.out.println("Element " + value + " already exists.");
            }
        }
        System.out.println("Add element(s) successfully.");
    }

    public static void showAllElements() {
        if (list.isEmpty()) {
            System.out.println("Set is empty.");
        } else {
            System.out.println("Elements in set: " + list);
        }
    }

    public static void sumAllElements() {
        int sum = 0;
        if (list.isEmpty()) {
            System.out.println("Set is empty.");
            return;
        }
        for (int element : list) {
            sum += element;
        }
        System.out.println("Sum of all elements: " + sum);
    }

    public static void findCommonElements() {
        System.out.print("Input number of elements in set 2: ");
        int n = readPositiveInteger();

        Set<Integer> set2 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + (i + 1) + " in set 2: ");
            set2.add(readPositiveInteger());
        }

        Set<Integer> commonElements = new TreeSet<>(list);
        commonElements.retainAll(set2);
        if (!commonElements.isEmpty()) {
            System.out.println("Common elements: " + commonElements);
        }
    }

    public static void findMinAndMaxElements() {
        int min = 0;
        int max = 0;
        if (list.isEmpty()) {
            System.out.println("Set is empty.");
            return;
        }
        min = Collections.min(list);
        max = Collections.max(list);

        showAllElements();
        System.out.println("Min element: " + min);
        System.out.println("Max element: " + max);
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