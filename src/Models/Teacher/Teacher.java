package Models.Teacher;

import Contracts.TeacherInterface;
import Contracts.UniversityMembersInterface;

public abstract class Teacher implements TeacherInterface {

    int id;

    String name;

    Double baseSalary;

    Double salary;

    int age;

    public Teacher(int id, String name, Double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public Double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public int getPersonalId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
