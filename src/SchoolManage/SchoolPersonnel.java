package SchoolManage;

public class SchoolPersonnel {

    private String fullName;
    private int age;
    private int workTime;

    private static int quantityOfPersonnel = 0;

    public SchoolPersonnel() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public SchoolPersonnel(String fullName, int age, int workTime) {
        this.fullName = fullName;
        this.age = age;
        this.workTime = workTime;
        quantityOfPersonnel++;
    }

    public void showName() {
        System.out.println("Full Name: " + fullName);
    }

    public void showInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Work Time: " + workTime + " hours");
    }

    public int getSalary() {
        return 0;
    }

    public static int getQuantityOfPersonnel() {
        return quantityOfPersonnel;
    }


}
