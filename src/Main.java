import model.Student;
import service.StudentManager;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        boolean running = true;

        while (running) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Find student");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        if (manager.findStudentById(id) != null) {
                            System.out.println("A student with this ID already exists.");
                            break;
                        }

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();

                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();

                        Student student = new Student(id, name, age, grade);

                        manager.addStudent(student);

                        break;

                    case 2:

                        manager.displayStudents();

                        break;

                    case 3:

                        System.out.print("Enter student ID: ");
                        int searchId = scanner.nextInt();

                        Student foundStudent =
                                manager.findStudentById(searchId);

                        if (foundStudent != null) {
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter student ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        if (manager.findStudentById(updateId) == null) {
                            System.out.println("Student not found.");
                            break;
                        }

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();

                        System.out.print("Enter new grade: ");
                        double newGrade = scanner.nextDouble();

                        boolean updated =
                                manager.updateStudent(
                                        updateId,
                                        newName,
                                        newAge,
                                        newGrade
                                );

                        if (updated) {
                            System.out.println("Student updated successfully.");
                        }

                        break;

                    case 5:

                        System.out.print("Enter student ID: ");
                        int deleteId = scanner.nextInt();

                        boolean deleted =
                                manager.deleteStudent(deleteId);

                        if (deleted) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }

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
}