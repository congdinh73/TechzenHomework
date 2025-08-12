package PhoneManage;

import PhoneManage.model.NewPhone;
import PhoneManage.model.OldPhone;
import PhoneManage.model.Phone;
import PhoneManage.utils.CheckInput;
import PhoneManage.utils.PhoneComparators;
import PhoneManage.utils.SortByFor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class PhoneManager {
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
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice! Please enter a valid number.");
                    e.printStackTrace();
                    continue;
                }
                String id;
                switch (choice) {
                    case 1:
                        menuDisplayPhone();
                        break;
                    case 2:
                        menuAddPhone();
                        break;
                    case 3:
                        System.out.println("Enter Phone ID to update: ");
                        id = CheckInput.readString();
                        Phone phone = findById(id);
                        if (phone != null) {
                            updatePhoneInformation(id);
                        } else {
                            System.out.println("No phone found with the ID: " + id + ". Please try again.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Phone ID to delete: ");
                        id = CheckInput.readString();
                        Phone phoneToDelete = findById(id);
                        if (phoneToDelete != null) {
                            deletePhone(id);
                        } else {
                            System.out.println("No phone found with the ID: " + id + ". Please try again.");
                        }
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
        int count = 1;
        int choice;
        do {
            while (true) {
                System.out.println("===== Menu 1 =====\nDISPLAY PHONE");
                System.out.println("1. Display all Phones");
                System.out.println("2. Display old phones");
                System.out.println("3. Display new phones");
                System.out.println("4. Back to main menu");
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice! Please enter a valid number.");
                    e.printStackTrace();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Displaying all Phones");
                        if (phones.isEmpty()) {
                            System.out.println("No phones available.");
                            return;
                        }
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Information of Phone " + (i + 1) + ":");
                            phones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("Displaying old phones");
                        if (phones.isEmpty()) {
                            System.out.println("No old phones available.");
                            return;
                        }
                        for (Phone oldPhone : phones) {
                            if (oldPhone instanceof OldPhone) {
                                System.out.println("Information of old Phone " + count++ + ":");
                                oldPhone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Displaying new phones");
                        if (phones.isEmpty()) {
                            System.out.println("No new phones available.");
                            return;
                        }
                        for (Phone newPhone : phones) {
                            if (newPhone instanceof NewPhone) {
                                System.out.println("Information of new Phone " + count++ + ":");
                                newPhone.output();
                            }
                        }
                        break;
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
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice! Please enter a valid number.");
                    e.printStackTrace();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Adding new Phone");
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        phones.add(newPhone);
                        System.out.println("New Phone added successfully!");
                        break;
                    case 2:
                        System.out.println("Adding old Phone");
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        phones.add(oldPhone);
                        System.out.println("Old Phone added successfully!");
                        break;
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
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice! Please enter a valid number.");
                    e.printStackTrace();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Sorting by price ascending");
                        sortByPrice(true);
                        System.out.println("---Listing phones after sorting---");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Information of Phone " + (i + 1) + ":");
                            phones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("Sorting by price descending");
                        sortByPrice(false);
                        System.out.println("---Listing phones after sorting---");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Information of Phone " + (i + 1) + ":");
                            phones.get(i).output();
                        }
                        break;
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
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice! Please enter a valid number.");
                    e.printStackTrace();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Searching by Phone name");
                        System.out.print("Enter the price to search: ");
                        double price = CheckInput.readPositiveInteger();
                        findPhoneByPrice(price);
                        break;
                    case 2:
                        System.out.println("Searching by Phone name");
                        System.out.print("Enter the Phone name to search: ");
                        String name = CheckInput.readString();
                        findPhoneByName(name);
                        break;
                    case 3:
                        System.out.println("Searching by Phone brand");
                        System.out.print("Enter the Phone brand to search: ");
                        String brand = CheckInput.readString();
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
        if (phones.isEmpty()) {
            System.out.println("No phones available to sort.");
            return;
        }
        if (ascending) {
            Collections.sort(phones, PhoneComparators.BY_PRICE_ASCENDING);
        } else {
            Collections.sort(phones, PhoneComparators.BY_PRICE_DESCENDING);
        }
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
                isFound = true;
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
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No phone found with the brand: " + brand);
        }
    }

    private static Phone findById(String id) {
        if (id == null || id.length() != 6 || !(id.startsWith("DTC") || id.startsWith("DTM"))) {
            System.out.println("Invalid ID format. ID must be 6 characters long and start with 'DTC' or 'DTM'.");
            return null;
        }

        for (Phone phone : phones) {
            if (phone.getId().equalsIgnoreCase(id)) {
                return phone;
            }
        }
        return null;
    }

    private static void updatePhoneInformation(String id) {
        try {
            Phone phone = findById(id);
            if (phone == null) {
                System.out.println("No phone found with the ID: " + id);
                return;
            }

            System.out.println("Current information of the Phone:");
            phone.output();
            System.out.println("Enter new information for the Phone:");
            phone.input();
            System.out.println("Phone information updated successfully!");
        }  catch (Exception e) {
            System.out.println("Error occurred while updating phone information: " + e.getMessage());
            System.out.println("Please try again.");
            updatePhoneInformation(id);
        }
    }

    private static void deletePhone(String id) {
        Phone phone = findById(id);
        if (phone == null) {
            System.out.println("No phone found with the ID: " + id);
            return;
        }

        System.out.println("Are you sure you want to delete the Phone with ID: " + id + "? (YES/NO)");
        String confirmation = CheckInput.readString();
        if (confirmation.equalsIgnoreCase("yes")) {
            phones.remove(phone);
            System.out.println("Phone with ID: " + id + " has been deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static double totalAmountOfPhones() {
        if (phones.isEmpty()) {
            System.out.println("No phones available.");
            return 0;
        } else {
            double total = 0;
            for (Phone phone : phones) {
                total += phone.totalPrice();
            }
            return total;
        }
    }

    private static void discountForOldPhones() {
        double discountPercent;
        while (true) {
            System.out.print("Enter a valid discount percentage (0-100): ");
            discountPercent = CheckInput.readPositiveInteger();
            if (discountPercent >= 0 && discountPercent <= 100) {
                break;
            } else {
                System.out.println("Invalid percentage! Please enter a number between 0 and 100.");
            }
        }

        int count = 0;
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).promote(discountPercent);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No old phones available for discount.");
        } else {
            System.out.printf("Successfully discounted %d old phone(s) by %.1f%%.\n", count, discountPercent);
        }
    }
}