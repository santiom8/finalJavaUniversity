import Models.Student.Student;
import Models.Teacher.Teacher;
import Models.University;
import Models.UniversityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    static void displayAllClassesOnMenu(University university) {
        university.getUniversityClasses().forEach(universityClass
                -> System.out.println(
                "Id " + universityClass.getId()
                        + " Name class:" + universityClass.getName()
                        + " Assigned classroom:" + universityClass.getAssignedClassroom()
                        + " Models.Teacher.Teacher:" + universityClass.getTeacher().getName()
                        + " Students:" + universityClass.getStudents().size()));
    }

    static void displayAllStudentsOnMenu(University university) {
        university.getStudents().forEach(student
                -> System.out.println(
                "Id " + student.getId()
                        + " Name:" + student.getName()
                        + " Age:" + student.getAge()));
    }

    static void displayAllTeachersOnMenu(University university) {
        university.getTeachers().forEach(teacher
                -> System.out.println(
                "Id " + teacher.getPersonalId()
                        + " Name:" + teacher.getName()
                        + " Age:" + teacher.getAge()
                        + " Salary:" + teacher.getSalary()));
    }

    static void createNewClassAddTeacherAndStudentsOption(University university, Scanner scanner) {
        int idClass;
        String nameClass;
        String assignedClassroom;
        String studentsId;
        int idTeacher;
        Teacher teacher;
        UniversityClass universityClass;
        String[] studentsIdArray;
        List<String> studentsIdList;
        //end variables
        System.out.println("Create a new class and add an existing teacher, existing students");
        System.out.println("Enter class identification");
        idClass = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter class name");
        nameClass = scanner.nextLine();
        System.out.println("Enter assigned classroom");
        assignedClassroom = scanner.nextLine();
        displayAllTeachersOnMenu(university);
        System.out.println("Enter teacher id");
        idTeacher = scanner.nextInt();
        teacher = university.getTeacherById(idTeacher);
        universityClass = new UniversityClass(idClass, nameClass, assignedClassroom, teacher, new ArrayList<>());
        scanner.nextLine();
        displayAllStudentsOnMenu(university);
        System.out.println("Enter students id separated by comma ex: 1,2,3");
        studentsId = scanner.nextLine();
        studentsIdArray = studentsId.split(",");
        studentsIdList = Arrays.asList(studentsIdArray);
        UniversityClass finalUniversityClass = universityClass;
        studentsIdList.forEach(studentId ->
                university.getStudents().stream()
                        .filter(student -> student.getId() == Integer.parseInt(studentId))
                        .forEach(finalUniversityClass::addStudent));
        university.addNewUniversityClasses(universityClass);
    }

    static void createStudentAndEnrollInClass(University university, Scanner scanner) {
        int id;
        String name;
        int age;
        scanner.nextLine();
        System.out.println("Please type the following: ");
        System.out.println("Identification student: ");
        id = scanner.nextInt();
        if(university.verifyExistenceStudent(id)){
            System.out.println("Student already exists");
            return;
        }
        scanner.nextLine();
        System.out.println("Complete name: ");
        name = scanner.nextLine();
        System.out.println("Age: ");
        age = scanner.nextInt();

        university.verifyExistenceStudent(id);
        Student student = new Student(id, name, age);
        university.addNewStudent(student);
        System.out.println("Choose class to enroll student");
        displayAllClassesOnMenu(university);
        int optionMenuClass = scanner.nextInt();
        UniversityClass universityClassSelected = university.getUniversityClassById(optionMenuClass);
        if (universityClassSelected != null) {
            universityClassSelected.addStudent(student);
            System.out.println("Student " + student.getName() + " has been enrolled in class " + universityClassSelected.getName());
        } else {
            System.out.println("Class not found");
        }

    }
}
