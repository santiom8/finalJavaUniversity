package Models;

import Models.Student.Student;
import Models.Teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {

    List<UniversityClass> universityClasses = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();

    List<Student> students = new ArrayList<>();

    public List<UniversityClass> getUniversityClasses() {
        return universityClasses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean verifyExistenceStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyExistenceClass(int id) {
        for (UniversityClass universityClass : universityClasses) {
            if (universityClass.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public UniversityClass getUniversityClassById(int id) {
        for (UniversityClass universityClass : universityClasses) {
            if (universityClass.getId() == id) {
                return universityClass;
            }
        }
        return null;
    }

    public Teacher getTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getPersonalId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void addNewStudent(Student student) {
        students.add(student);
    }

    public void addNewUniversityClasses(UniversityClass universityClass) {
        this.universityClasses.add(universityClass);
    }

    public void getClassesByStudentId(int id) {
        universityClasses.forEach(universityClass -> {
            universityClass.getStudents().forEach(student -> {
                if (student.getId() == id) {
                    System.out.println(
                    "Id " + universityClass.getId()
                            + " Name class: " + universityClass.getName()
                            + " Assigned classroom: " + universityClass.getAssignedClassroom()
                            + " Models.Teacher.Teacher: " + universityClass.getTeacher().getName()
                            + " Students: " + universityClass.getStudents().size());
                }
            });
        });
    }
}
