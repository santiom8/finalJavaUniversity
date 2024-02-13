import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public static void initializeStudents(List<Student> students) {
        students.add(new Student(1, "John", 12));
        students.add(new Student(2, "Jane", 18));
        students.add(new Student(3, "Doe", 20));
        students.add(new Student(4, "Smith", 22));
        students.add(new Student(5, "Alex", 19));
        students.add(new Student(6, "Eva", 21));
    }

    public static void initializeTeachers(List<Teacher> teachers) {
        teachers.add(new FullTimeTeacher(1, "Alice", 2500000.00, 6));
        teachers.add(new FullTimeTeacher(2, "Bob", 4000000.00, 10));
        teachers.add(new PartTimeTeacher(3, "Charlie", 3000000.00, 12));
        teachers.add(new PartTimeTeacher(4, "David", 2000000.00, 15));
    }

    public static void initializeClasses(University university) {
        List<Student> students = university.getStudents();
        List<Teacher> teachers = university.getTeachers();
        List<UniversityClass> universityClasses = university.getUniversityClasses();

        universityClasses.add(new UniversityClass(1, "English", "41-301", teachers.get(0), students));
        universityClasses.add(new UniversityClass(2, "Math", "47-403", teachers.get(1), students));
        universityClasses.add(new UniversityClass(3, "Computer Science", "30-201", teachers.get(2), students));
        universityClasses.add(new UniversityClass(4, "Physics", "41-301", teachers.get(3), students));
    }
}
