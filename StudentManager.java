import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // CREATE
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // READ
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // READ ONE
    public Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // UPDATE
    public boolean updateStudent(int id, String name, int age, double grade) {

        Student student = findStudentById(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);

            return true;
        }

        return false;
    }

    // DELETE
    public boolean deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}