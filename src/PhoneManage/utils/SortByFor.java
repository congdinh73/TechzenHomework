package PhoneManage;

import PhoneManage.Model.Phone;

import java.util.List;

public class SortByFor {
    public static void sortByFor(List<Phone> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double salaryI = list.get(i).getPrice();
                double salaryJ = list.get(j).getPrice();

                boolean needSwap = ascending ? salaryI > salaryJ : salaryI < salaryJ;

                if (needSwap) {
                    Phone temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
