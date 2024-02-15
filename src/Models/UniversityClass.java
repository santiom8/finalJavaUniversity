package Models;

import Models.Student.Student;
import Models.Teacher.Teacher;

import java.util.List;

public class UniversityClass {
    private int id;
    private String name;
    private String assignedClassroom;

    private Teacher teacher;
    private List<Student> students;

    public UniversityClass(int id, String name, String assignedClassroom, Teacher teacher, List<Student> students) {
        this.id = id;
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.teacher = teacher;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public void setAssignedClassroom(String assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }


}
