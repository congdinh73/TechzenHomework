package ss5_polymorphism.employee_manager.Utils;

import ss5_polymorphism.employee_manager.Employee;

import java.util.List;

public class SortUtils {
    public static void sortByFor(List<Employee> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double salaryI = list.get(i).getSalary();
                double salaryJ = list.get(j).getSalary();

                boolean needSwap = ascending ? salaryI > salaryJ : salaryI < salaryJ;

                if (needSwap) {
                    Employee temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
