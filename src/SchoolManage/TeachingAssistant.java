package SchoolManage;

public class TeachingAssistant extends SchoolPersonnel {
    private String supportSubject;
    private int salaryOfTeachingAssistant = 100000;

    public TeachingAssistant() {
    }

    public TeachingAssistant(String fullName, int age, int workTime, String supportSubject) {
        super(fullName, age, workTime);
        this.supportSubject = supportSubject;
    }

    @Override
    public int getSalary() {
        return getWorkTime() * salaryOfTeachingAssistant;
    }
}
