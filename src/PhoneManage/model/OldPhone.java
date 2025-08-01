package PhoneManage.model;


import PhoneManage.utils.CheckInput;
import PhoneManage.utils.IdGenerator;
import PhoneManage.service.Promotion;

import java.util.Scanner;

public class OldPhone extends Phone implements Promotion {
    static Scanner scanner = new Scanner(System.in);

    private double batteryLife;


    public OldPhone() {
    }

    @Override
    public double totalPrice() {
        return price * batteryLife / 100;
    }

    @Override
    public void input() {
        this.id = IdGenerator.generateOldPhoneId();
        System.out.print("Enter old phone name: ");
        this.phoneName = CheckInput.readString();
        System.out.print("Enter price: ");
        this.price = CheckInput.readPositiveInteger();
        System.out.print("Enter time of maintenance: ");
        this.timeMaintenance = CheckInput.readString();
        System.out.print("Enter OS: ");
        this.OS = CheckInput.readString();
        System.out.print("Enter brand: ");
        this.brand = CheckInput.readString();
        System.out.print("Enter battery life (in percentage): ");
        this.batteryLife = CheckInput.readPositiveInteger();

    }

    @Override
    public void output() {
        super.output();
        System.out.println("Battery Life: " + batteryLife + "%");
    }

    @Override
    public void promote(double percent) {
        this.price = this.price * (1 - percent / 100);
    }

    public OldPhone(String id, String phoneName, double price, String timeMaintenance, String OS, String brand, double batteryLife) {
        super(id, phoneName, price, timeMaintenance, OS, brand);
        this.batteryLife = batteryLife;
    }
}
