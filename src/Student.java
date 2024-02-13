import Contracts.UniversityMembersInterface;

public class Student implements UniversityMembersInterface {

    int id;
    String name;
    int age;

    public Student(int personalId, String name, int age) {
        this.id = personalId;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonalId(int personalId) {
        this.id = personalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
}
