package TeacherManage;

public class Teacher {
    private String fullName;
    private int age;
    private String subject;
    private int workingHours;

    static int quantity = 0;

    public Teacher() {
    }

    public Teacher(String fullName, int age, String subject, int workingHours) {
        this.fullName = fullName;
        this.age = age;
        this.subject = subject;
        this.workingHours = workingHours;
        quantity++;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
