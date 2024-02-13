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

    public boolean verifyExistenceStudent(int id){
        for (Student student : students){
            if (student.getId() == id){
                return true;
            }
        }
        return false;
    }

    public UniversityClass getUniversityClassById(int id){
        for (UniversityClass universityClass : universityClasses){
            if (universityClass.getId() == id){
                return universityClass;
            }
        }
        return null;
    }
}
