import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean running = true;

        while (running) {

            displayMenu();

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        addStudent(scanner, manager);
                        break;

                    case 2:
                        displayStudents(manager);
                        break;

                    case 3:
                        findStudent(scanner, manager);
                        break;

                    case 4:
                        updateStudent(scanner, manager);
                        break;

                    case 5:
                        deleteStudent(scanner, manager);
                        break;

                    case 6:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a valid value.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Display the main menu
    public static void displayMenu() {

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. Display students");
        System.out.println("3. Find student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // CREATE
    public static void addStudent(
            Scanner scanner,
            StudentManager manager) {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (manager.findStudentById(id) != null) {

            System.out.println(
                    "A student with this ID already exists.");

            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        Student student =
                new Student(id, name, age, grade);

        manager.addStudent(student);
    }

    // READ
    public static void displayStudents(
            StudentManager manager) {

        manager.displayStudents();
    }

    // READ ONE
    public static void findStudent(
            Scanner scanner,
            StudentManager manager) {

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student =
                manager.findStudentById(id);

        if (student != null) {

            System.out.println(student);

        } else {

            System.out.println("Student not found.");
        }
    }

    // UPDATE
    public static void updateStudent(
            Scanner scanner,
            StudentManager manager) {

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student =
                manager.findStudentById(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();

        System.out.print("Enter new grade: ");
        double grade = scanner.nextDouble();

        boolean updated =
                manager.updateStudent(
                        id,
                        name,
                        age,
                        grade
                );

        if (updated) {

            System.out.println(
                    "Student updated successfully.");
        }
    }

    // DELETE
    public static void deleteStudent(
            Scanner scanner,
            StudentManager manager) {

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        boolean deleted =
                manager.deleteStudent(id);

        if (deleted) {

            System.out.println(
                    "Student deleted successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }
}