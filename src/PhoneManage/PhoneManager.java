package PhoneManage;

import PhoneManage.Model.NewPhone;
import PhoneManage.Model.OldPhone;
import PhoneManage.Model.Phone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManage {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Phone> phones = new ArrayList<>();

    public static void showMenu() {
        int choice;
        do {
            while (true) {
                System.out.println("==== Main Menu ====\n PHONE SYSTEM MANAGEMENT");
                System.out.println("1. Display all Phones");
                System.out.println("2. Add new Phone");
                System.out.println("3. Update Phone information");
                System.out.println("4. Delete Phone");
                System.out.println("5. Sort Phones by price");
                System.out.println("6. Search Phone");
                System.out.println("7. Total amount of Phones");
                System.out.println("8. Discount for older Phones");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        menuDisplayPhone();
                        break;
                    case 2:
                        menuAddPhone();
                        break;
                    case 3:
                        System.out.print("Enter Phone ID to update: ");
                        String id = scanner.nextLine();
                        updatePhoneInformation(id);
                        break;
                    case 4:
                        System.out.print("Enter Phone ID to delete: ");
                        String deleteId = scanner.nextLine();
                        deletePhone(deleteId);
                        break;
                    case 5:
                        menuSortPhoneByPrice();
                        break;
                    case 6:
                        menuSearchPhoneByName();
                        break;
                    case 7:
                        System.out.println("Total amount of Phones: " + totalAmountOfPhones());
                        break;
                    case 8:
                        discountForOldPhones();
                        break;
                    case 9:
                        return;

                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 9.");
                        break;
                }
            }
        } while (choice < 1 || choice > 9);
    }

    private static void menuDisplayPhone() {
        int choice;
        do {
            while (true) {
                System.out.println("===== Menu 1 =====\nDISPLAY PHONE");
                System.out.println("1. Display all Phones");
                System.out.println("2. Display old phones");
                System.out.println("3. Display new phones");
                System.out.println("4. Back to main menu");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Displaying all Phones");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Information of Phone " + (i + 1) + ":");
                            phones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("Displaying old phones");
                        for (Phone oldPhone : phones) {
                            if (oldPhone instanceof OldPhone) {
                                oldPhone.output();
                            }
                        }
                    case 3:
                        System.out.println("Displaying new phones");
                        for (Phone newPhone : phones) {
                            if (newPhone instanceof NewPhone) {
                                newPhone.output();
                            }
                        }
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            }
        } while (choice < 1 || choice > 4);
    }

    private static void menuAddPhone() {
        int choice;
        do {
            while (true) {
                System.out.println("===== Menu 2 =====\nADD PHONE");
                System.out.println("1. Add new Phone");
                System.out.println("2. Add old Phone");
                System.out.println("3. Back to main menu");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Adding new Phone");
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        System.out.println("New Phone added successfully!");
                    case 2:
                        System.out.println("Adding old Phone");
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        System.out.println("Old Phone added successfully!");
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                }
            }
        } while (choice < 1 || choice > 3);
    }

    private static void menuSortPhoneByPrice() {
        int choice;
        do {
            while (true) {
                System.out.println("===== Menu 5 =====\nSORT PHONE");
                System.out.println("1. Sort by price ascending");
                System.out.println("2. Sort by price descending");
                System.out.println("3. Back to main menu");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Sorting by price ascending");
                        sortByPrice(true);
                        for (Phone phone : phones) {
                            System.out.println("Listing phones after sorting:");
                            phone.output();
                        }
                    case 2:
                        System.out.println("Sorting by price descending");
                        sortByPrice(false);
                        for (Phone phone : phones) {
                            System.out.println("Listing phones after sorting:");
                            phone.output();
                        }
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                }
            }
        } while (choice < 1 || choice > 3);
    }

    private static void menuSearchPhoneByName() {
        int choice;
        do {
            while (true) {
                System.out.println("===== Menu 6 =====\nSEARCH PHONE");
                System.out.println("1. Search by Phone price");
                System.out.println("2. Search by Phone name");
                System.out.println("3. Search by Phone brand");
                System.out.println("4. Back to main menu");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Searching by Phone name");
                        System.out.print("Enter the price to search: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        findPhoneByPrice(price);
                        break;
                    case 2:
                        System.out.println("Searching by Phone name");
                        System.out.print("Enter the Phone name to search: ");
                        String name = scanner.nextLine();
                        findPhoneByName(name);
                        break;
                    case 3:
                        System.out.println("Searching by Phone brand");
                        System.out.print("Enter the Phone brand to search: ");
                        String brand = scanner.nextLine();
                        findPhoneByBrand(brand);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            }
        } while (choice < 1 || choice > 4);
    }

    private static void sortByPrice(boolean ascending) {
        SortByFor.sortByFor(phones, ascending);
    }

    private static void findPhoneByPrice(double price) {
        boolean isFound = false;
        for (Phone phone : phones) {
            if (phone.getPrice() == price) {
                phone.output();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the price: " + price);
        }
    }

    private static void findPhoneByName(String name) {
        boolean isFound = false;
        for (Phone phone : phones) {
            if (phone.getPhoneName().toLowerCase().contains(name.toLowerCase())) {
                phone.output();
                return;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the name: " + name);
        }
    }

    private static void findPhoneByBrand(String brand) {
        boolean isFound = false;
        for (Phone phone : phones) {
            if (phone.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                phone.output();
                return;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the brand: " + brand);
        }
    }

    private static void updatePhoneInformation(String id) {
        boolean isFound = false;
        if (id == null || id.length() != 6 || !(id.startsWith("DTC") || id.startsWith("DTM"))) {
            System.out.println("Invalid ID format. ID must be 6 characters long and start with 'DTC' or 'DTM'.");
            return;
        }
        for (Phone phone : phones) {
            if (phone.getId().toLowerCase().contains(id.toLowerCase())) {
                System.out.println("Updating information for Phone with ID: " + id);
                phone.input();
                System.out.println("Phone information updated successfully!");
                return;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the ID: " + id);
        }
    }

    private static void deletePhone(String id) {
        boolean isFound = false;
        if (id == null || id.length() != 6 || !(id.startsWith("DTC") || id.startsWith("DTM"))) {
            System.out.println("Invalid ID format. ID must be 6 characters long and start with 'DTC' or 'DTM'.");
            return;
        }
        for (Phone phone : phones) {
            if (phone.getId().toLowerCase().contains(id.toLowerCase())) {
                System.out.println("You are about to delete the Phone with ID: " + id);
                System.out.print("Are you sure you want to delete this Phone? (yes/no): ");
                String confirm = String.valueOf(scanner.nextLine()).toLowerCase();
                if (!confirm.equals("yes")) {
                    System.out.println("Deletion cancelled.");
                    return;
                }
                phones.remove(phone);
                System.out.println("Phone with ID: " + id + " has been deleted successfully!");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the ID: " + id);
        }
    }

    private static double totalAmountOfPhones() {
        double total = 0;
        for (Phone phone : phones) {
            total += phone.totalPrice();
        }
        return total;
    }

    private static void discountForOldPhones() {
        System.out.print("Enter discount percentage for old phones: ");
        double discountPercent = Double.parseDouble(scanner.nextLine());
        if (discountPercent < 0 || discountPercent > 100) {
            System.out.println("Invalid discount percentage! Please enter a value between 0 and 100.");
            return;
        }
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).promote(discountPercent);
                System.out.println("Discount applied to old phone with ID: " + phone.getId());
            } else {
                System.out.println("No old phones found to apply discount.");
            }
        }
    }
}