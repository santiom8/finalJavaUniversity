import Models.Student.Student;
import Models.Teacher.Teacher;
import Models.University;
import Models.UniversityClass;
import SeedDataInitializer.Initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        University university = new University();
        initInitialData(university);
        initializeMenu(university);

    }

    static void initializeMenu(University university) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1) Show all teachers");
            System.out.println("2) Show all classes");
            System.out.println("3) Create student and enroll in class");
            System.out.println("4) Create a new class and add an existing teacher, existing students");
            System.out.println("5) List all the classes given a student id");
            System.out.println("6) Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayAllTeachersOnMenu(university);
                    scanner.close();
                    break;
                case 2:
                    displayAllClassesOnMenu(university);
                    scanner.close();
                    break;
                case 3:
                    //variables
                    int id;
                    String name;
                    int age;
                    scanner.nextLine();
                    System.out.println("Please type the following: ");
                    System.out.println("Identification student: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Complete name: ");
                    name = scanner.nextLine();
                    System.out.println("Age: ");
                    age = scanner.nextInt();

                    if (!university.verifyExistenceStudent(id)) {
                        Student student = new Student(id, name, age);
                        university.addNewStudent(student);
                        System.out.println("Choose class to enroll student");
                        displayAllClassesOnMenu(university);
                        int optionMenuClass = scanner.nextInt();
                        UniversityClass universityClassSelected = university.getUniversityClassById(optionMenuClass);
                        if (universityClassSelected != null) {
                            universityClassSelected.addStudent(student);
                            System.out.println("Models.Student.Student " + student.getName() + " has been enrolled in class " + universityClassSelected.getName());
                        } else {
                            System.out.println("Class not found");
                        }
                    } else {
                        System.out.println("Models.Student.Student already exists");
                    }
                    scanner.close();
                    break;
                case 4:
                    //Variables
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
                    scanner.close();
                    break;
                case 5:
                    System.out.println("Enter student id");
                    int studentId = scanner.nextInt();
                    university.getClassesByStudentId(studentId);
                    break;
                case 6:
                    System.out.println("Goodbye");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    static void initInitialData(University university) {
        Initializer.initializeStudents(university.getStudents());
        Initializer.initializeTeachers(university.getTeachers());
        Initializer.initializeClasses(university);
    }

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
}