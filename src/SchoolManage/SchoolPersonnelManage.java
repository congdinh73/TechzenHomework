package SchoolManage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SchoolPersonnelManage {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<SchoolPersonnel> schoolPersonnelList = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

    public void run() {
        while (true) {
            clearScreen();
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addPersonnel();
                case 2 -> showAllPersonnel();
                case 3 -> findPersonnelByName();
                case 4 -> showQuantityOfPersonnel();
                case 5 -> findMostWorkingHours();
                case 6 -> personnelWorkLessThan20Hours(20);
                case 7 -> showSalaryOfPersonnel();
                case 8 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showMenu() {
        System.out.println("=====Welcome to School Personnel Management System=====");
        System.out.println("Please choose an option from the menu");
        System.out.println("1. Add Personnel (Teacher or Teaching Assistant)");
        System.out.println("2. Show all Personnel");
        System.out.println("3. Find Personnel by Name");
        System.out.println("4. Show quantity of Personnel");
        System.out.println("5. Find most working hours");
        System.out.println("6. Show personnel with working hours less than 20 of month");
        System.out.println("7. Show salary of Personnel");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addPersonnel() {
        int type;
        do {
            System.out.print("Enter the type of personnel (1 for Teacher, 2 for Teaching Assistant): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            type = scanner.nextInt();
            scanner.nextLine();
            if (type != 1 && type != 2) {
                System.out.println("Invalid type. Please enter 1 for Teacher or 2 for Teaching Assistant.");
            }
        } while (type != 1 && type != 2);

        System.out.print("Enter full name: ");
        while (scanner.hasNextLine()) {
            String fullName = scanner.nextLine();
            if (fullName.isBlank()) {
                System.out.println("Full name cannot be blank. Please enter a valid full name.");
            } else {
                System.out.print("Enter age: ");
                int age = readPositiveInteger();
                System.out.print("Enter work time (in hours): ");
                int workTime = readPositiveInteger();
                if (type == 1) {
                    System.out.print("Enter teaching subject: ");
                    String teachingSubject = scanner.nextLine();
                    schoolPersonnelList.add(new Teacher(fullName, age, workTime, teachingSubject));
                } else {
                    System.out.print("Enter support subject: ");
                    String supportSubject = scanner.nextLine();
                    schoolPersonnelList.add(new TeachingAssistant(fullName, age, workTime, supportSubject));
                }
                break;
            }
        }
    }

    public void showAllPersonnel() {
        if (schoolPersonnelList.isEmpty()) {
            System.out.println("No personnel found.");
        } else {
            System.out.println("List of all personnel:");
            for (int i = 0; i < schoolPersonnelList.size(); i++) {
                System.out.println("Personnel " + (i + 1) + ":");
                schoolPersonnelList.get(i).showName();
                System.out.println("-----------------------------");
            }
        }
    }

    public void findPersonnelByName() {
        System.out.print("Enter the full name of the personnel to search: ");
        if (scanner.hasNextLine()) {
            String fullName = scanner.nextLine();
            boolean found = false;
            for (SchoolPersonnel personnel : schoolPersonnelList) {
                if (personnel.getFullName().toLowerCase().contains(fullName.toLowerCase())) {
                    personnel.showInfo();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No personnel found with the name: " + fullName);
            }
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void showQuantityOfPersonnel() {
        System.out.println("Total number of personnel: " + SchoolPersonnel.getQuantityOfPersonnel());
    }

    public void findMostWorkingHours() {
        int maxWorkTime = 0;
        ArrayList<SchoolPersonnel> mostWorkTime = new ArrayList<>();
        for (SchoolPersonnel personnel : schoolPersonnelList) {
            if (personnel.getWorkTime() > maxWorkTime) {
                maxWorkTime = personnel.getWorkTime();
                mostWorkTime.clear();
                mostWorkTime.add(personnel);
            } else if (personnel.getWorkTime() == maxWorkTime) {
                mostWorkTime.add(personnel);
            }
        }
        System.out.println("Personnel(s) with the most working hours:");
        for (SchoolPersonnel p : mostWorkTime) {
            p.showName();
        }
    }

    public void personnelWorkLessThan20Hours(int workTime) {
        boolean found = false;
        for (SchoolPersonnel personnel : schoolPersonnelList) {
            if (personnel.getWorkTime() < workTime) {
                personnel.showInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No personnel found with working hours less than " + workTime + " hours.");
        }
    }

    public void showPersonnelWithTitle(SchoolPersonnel p, int index, boolean showSalary) {
        System.out.println("Personnel " + index + ":");
        p.showInfo();
        if (showSalary) {
            System.out.println("Salary: " + numberFormat.format(p.getSalary()));
        }
        System.out.println("-----------------------------");
    }

    public void showSalaryOfPersonnel() {
        System.out.println("List of personnel with their salaries:");
        for (int i = 0; i < schoolPersonnelList.size(); i++) {
            showPersonnelWithTitle(schoolPersonnelList.get(i), i + 1, true);
        }
    }

    public int readPositiveInteger() {
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
