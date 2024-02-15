import Models.University;
import SeedDataInitializer.Initializer;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        University university = new University();
        Scanner scanner = new Scanner(System.in);
        initInitialData(university);
        initializeMenu(university, scanner);
    }

    static void initializeMenu(University university, Scanner scanner) {
        int option = 0;
        while (option != 6) {
            try {
                System.out.println();
                System.out.println("Choose an option");
                System.out.println("1) Show all teachers");
                System.out.println("2) Show all classes and get information about them");
                System.out.println("3) Create student and enroll in class");
                System.out.println("4) Create a new class and add an existing teacher, existing students");
                System.out.println("5) List all the classes given a student id");
                System.out.println("6) Exit");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Result:");
                        MenuUtils.displayAllTeachersOnMenu(university);
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Result:");
                        MenuUtils.displayAndSelectClass(university, scanner);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Result:");
                        MenuUtils.createStudentAndEnrollInClass(university, scanner);
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Result:");
                        MenuUtils.createNewClassAddTeacherAndStudentsOption(university, scanner);
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Enter student id");
                        int studentId = scanner.nextInt();
                        System.out.println("Result:");
                        university.getClassesByStudentId(studentId);
                        break;
                    case 6:
                        System.out.println("Goodbye...");
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
    }

    static void initInitialData(University university) {
        Initializer.initializeStudents(university.getStudents());
        Initializer.initializeTeachers(university.getTeachers());
        Initializer.initializeClasses(university);
    }
}