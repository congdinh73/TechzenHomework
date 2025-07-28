package SchoolManage;

public class Teacher extends SchoolPersonnel {
    private String teachingSubject;
    private int salaryOfTeacher = 200000;

    public Teacher() {
    }

    public Teacher(String fullName, int age, int workTime, String teachingSubject) {
        super(fullName, age, workTime);
        this.teachingSubject = teachingSubject;
    }

    @Override
    public int getSalary() {
        return getWorkTime() * salaryOfTeacher;
    }
}
