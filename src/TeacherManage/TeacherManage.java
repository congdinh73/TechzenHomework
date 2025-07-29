package TeacherManage;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherManage {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Teacher> teacherList = new ArrayList<>();

    public void run() {
        while (true) {
            clearScreen();
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addTeacher();
                case 2 -> showAllTeachers();
                case 3 -> findTeacherByName();
                case 4 -> showQuantityOfTeachers();
                case 5 -> findMostWorkingHours();
                case 6 -> teachersWorkLessThan20Hours(20);
                case 7 -> {
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
        System.out.println("=====Welcome to Teacher Management System=====");
        System.out.println("Please choose an option from the menu");
        System.out.println("1. Add Teacher");
        System.out.println("2. Show all Teachers");
        System.out.println("3. Find Teacher by Name");
        System.out.println("4. Show quantity of Teachers");
        System.out.println("5. Find most working hours");
        System.out.println("6. Show teachers with working hours less than 20 of month");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addTeacher() {
        System.out.print("Enter Teacher's full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Teacher's age: ");
        int age = readPositiveInteger();
        System.out.print("Enter Teacher's subject: ");
        String subject = scanner.nextLine();
        if (subject.isEmpty()) {
            System.out.print("Subject cannot be empty.");
            return;
        }
        System.out.print("Enter Teacher's working hours: ");
        int workingHours = readPositiveInteger();
        if (workingHours < 0) {
            System.out.println("Working hours cannot be negative.");
            return;
        }
        Teacher teacher = new Teacher(fullName, age, subject, workingHours);
        teacherList.add(teacher);
        System.out.println("Teacher added successfully: " + teacher.getFullName());
    }

    public void showAllTeachers() {
        if (teacherList.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }
        System.out.println("List of Teachers:");
        for (Teacher teacher : teacherList) {
            System.out.println("Full Name: " + teacher.getFullName() +
                    ", Age: " + teacher.getAge() +
                    ", Subject: " + teacher.getSubject() +
                    ", Working Hours: " + teacher.getWorkingHours());
            System.out.println("-----------------------------------");
        }
    }

    public void findTeacherByName() {
        System.out.print("Enter Teacher's full name to search: ");
        String fullName = scanner.nextLine();
        for (Teacher teacher : teacherList) {
            if (teacher.getFullName().toLowerCase().contains(fullName.toLowerCase())) {
                System.out.println("Found Teacher: " + teacher.getFullName() +
                        ", Age: " + teacher.getAge() +
                        ", Subject: " + teacher.getSubject() +
                        ", Working Hours: " + teacher.getWorkingHours());
                return;
            }
        }
        System.out.println("No Teacher found with the name: " + fullName);
    }

    public void showQuantityOfTeachers() {
        System.out.println("Total number of Teachers: " + Teacher.quantity);
    }

    public void findMostWorkingHours() {
        if (teacherList.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }
        Teacher mostWorkingTeacher = teacherList.get(0);
        for (Teacher teacher : teacherList) {
            if (teacher.getWorkingHours() > mostWorkingTeacher.getWorkingHours()) {
                mostWorkingTeacher = teacher;
            }
        }
        System.out.println("Teacher with most working hours: " + mostWorkingTeacher.getFullName() + ", Working Hours: " + mostWorkingTeacher.getWorkingHours());
    }

    public void teachersWorkLessThan20Hours(int workingHours) {
        if (teacherList.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }
        System.out.println("Teachers with working hours less than " + workingHours + ":");
        boolean found = false;
        for (Teacher teacher : teacherList) {
            if (teacher.getWorkingHours() < workingHours) {
                System.out.println("Full Name: " + teacher.getFullName() + ", " +
                        "Age: " + teacher.getAge() + ", " +
                        "Subject: " + teacher.getSubject() + ", " +
                        "Working Hours: " + teacher.getWorkingHours());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No teachers found with working hours less than " + workingHours);
        }
    }

    // Method to read a positive integer from the user
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
