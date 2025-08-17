package PhoneManage.model;


import PhoneManage.utils.CheckInput;
import PhoneManage.utils.IdGenerator;

import java.util.Scanner;

public class NewPhone extends Phone {
    static Scanner scanner = new Scanner(System.in);

    private int quantity;

    public NewPhone() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double totalPrice() {
        return price * quantity;
    }

    @Override
    public void input() {
        try {
            this.id = IdGenerator.generateNewPhoneId();
            System.out.print("Enter new phone name: ");
            this.phoneName = CheckInput.readString();
            System.out.print("Enter price: ");
            this.price = CheckInput.readPositiveInteger();
            System.out.print("Enter time of maintenance: ");
            this.timeMaintenance = CheckInput.readString();
            System.out.print("Enter OS: ");
            this.OS = CheckInput.readString();
            System.out.print("Enter brand: ");
            this.brand = CheckInput.readString();
            System.out.print("Enter quantity: ");
            this.quantity = CheckInput.readPositiveInteger();
        } catch (Exception e) {
            System.out.println("Error occurred while entering phone information: " + e.getMessage());
            input();
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Quantity: " + quantity);
    }

    public NewPhone(String id, String phoneName, double price, String timeMaintenance, String OS, String brand, int quantity) {
        super(id, phoneName, price, timeMaintenance, OS, brand);
        this.quantity = quantity;
    }


}
