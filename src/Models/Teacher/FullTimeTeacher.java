package Models.Teacher;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;

    public FullTimeTeacher(int id, String name, Double baseSalary, int experienceYears) {
        super(id, name, baseSalary);
        this.experienceYears = experienceYears;
        setSalary(baseSalary*1.1*experienceYears);
    }
}
