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
            System.out.println("3) Show all students");
            System.out.println("4) Enroll student");
            System.out.println("5) List all the classes given a student id");
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
                    int id;
                    String name;
                    int age;
                    scanner.nextLine();
                    System.out.println("Please type the following: ");
                    System.out.println("Identification student: ");
                    id = scanner.nextInt();
                    System.out.println("Complete name: ");
                    name = scanner.nextLine();
                    System.out.println("Age: ");
                    age = scanner.nextInt();

                    if (!university.verifyExistenceStudent(id)) {
                        Student student = new Student(id, name, age);
                        System.out.println("Choose class to enroll student");
                        displayAllClassesOnMenu(university);
                        int optionMenuClass = scanner.nextInt();
                        UniversityClass universityClassSelected  = university.getUniversityClassById(optionMenuClass);
                        if (universityClassSelected != null) {
                           universityClassSelected.addStudent(student);
                           System.out.println("Student "+student.name+" has been enrolled in class "+universityClassSelected.getName());
                        } else {
                            System.out.println("Class not found");
                        }
                    } else {
                        System.out.println("Student already exists");
                    }
                    scanner.close();
                    break;
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
                        + " Teacher:" + universityClass.getTeacher().getName()
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