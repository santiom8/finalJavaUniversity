public class PartTimeTeacher extends Teacher {
    int hoursPerWeek;

    public PartTimeTeacher(int id, String name, Double baseSalary, int hoursPerWeek) {
        super(id, name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
        setSalary(baseSalary * hoursPerWeek);
    }
}
