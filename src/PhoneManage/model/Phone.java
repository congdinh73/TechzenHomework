package PhoneManage.model;

import PhoneManage.service.Promotion;

public abstract class Phone implements Comparable<Phone> {

    public String id;
    public String phoneName;
    public double price;
    public String timeMaintenance;
    public String OS;
    public String brand;

    public Phone() {
    }

    public Phone(String id, String phoneName, double price, String timeMaintenance, String OS, String brand) {
        this.id = id;
        this.phoneName = phoneName;
        this.price = price;
        this.timeMaintenance = timeMaintenance;
        this.OS = OS;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimeMaintenance() {
        return timeMaintenance;
    }

    public void setTimeMaintenance(String timeMaintenance) {
        this.timeMaintenance = timeMaintenance;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract double totalPrice();

    public abstract void input();

    public void output() {
        System.out.println("ID: " + id +
                ", Phone Name: " + phoneName +
                ", Price: " + price +
                ", Time of Maintenance: " + timeMaintenance +
                ", OS: " + OS +
                ", Brand: " + brand);
    }

    @Override
    public int compareTo(Phone o) {
        return Double.compare(this.price, o.price);
    }
}
