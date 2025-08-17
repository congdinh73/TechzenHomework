package PhoneManage.utils;

import PhoneManage.model.NewPhone;
import PhoneManage.model.OldPhone;
import PhoneManage.model.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    private static final String CSV_FILE = "src/PhoneManage/data/phone.csv";

    public static List<Phone> readFromCSV() {
        List<Phone> phones = new ArrayList<>();
        File flie = new File(CSV_FILE);
        if (!flie.exists()) {
            return phones;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",", -1);
                if (data.length == 8) {
                    String id = data[0];
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String warranty = data[3];
                    String brand = data[4];
                    String batteryStr = data[5];
                    String qtyStr = data[6];

                    if (id.startsWith("DTC")) {
                        double battery = batteryStr.isEmpty() ? 0 : Double.parseDouble(batteryStr);
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.setId(id);
                        oldPhone.setPhoneName(name);
                        oldPhone.setPrice(price);
                        oldPhone.setTimeMaintenance(warranty);
                        oldPhone.setOS("");
                        oldPhone.setBrand(brand);
                        oldPhone.setBatteryLife(battery);
                        phones.add(oldPhone);
                    } else if (id.startsWith("DTM")) {
                        int qty = qtyStr.isEmpty() ? 0 : Integer.parseInt(qtyStr);
                        NewPhone newPhone = new NewPhone();
                        newPhone.setId(id);
                        newPhone.setPhoneName(name);
                        newPhone.setPrice(price);
                        newPhone.setTimeMaintenance(warranty);
                        newPhone.setOS("");
                        newPhone.setBrand(brand);
                        newPhone.setQuantity(qty);
                        phones.add(newPhone);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading CSV file: " + e.getMessage());
        }

        return phones;
    }

    public static void writeToCSV(List<Phone> phones) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            for (Phone phone : phones) {
                StringBuilder line = new StringBuilder();
                line.append(phone.getId()).append(",");
                line.append(phone.getPhoneName()).append(",");
                line.append(phone.getPrice()).append(",");
                line.append(phone.getTimeMaintenance()).append(",");
                line.append(phone.getBrand()).append(",");

                if (phone instanceof OldPhone) {
                    OldPhone oldPhone = (OldPhone) phone;
                    line.append(oldPhone.getBatteryLife()).append(",");
                    line.append(",");
                    line.append("");
                } else if (phone instanceof NewPhone) {
                    NewPhone newPhone = (NewPhone) phone;
                    line.append(",");
                    line.append("");
                    line.append(newPhone.getQuantity()).append(",");
                }

                bw.write(line.toString());
                bw.newLine();
            }
            System.out.println("Data saved to phone.csv successfully!");
        } catch (Exception e) {
            System.out.println("Error occurred while writing CSV file: " + e.getMessage());
        }
    }


}
