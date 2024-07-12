import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class to represent individual students
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

// StudentManagementSystem class to manage the collection of students
class StudentManagementSystem {
    private List<Student> studentList;

    public StudentManagementSystem() {
        studentList = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Method to remove a student
    public void removeStudent(int rollNumber) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNumber() == rollNumber) {
                studentList.remove(i);
                System.out.println("Student with roll number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Method to search for a student by roll number
    public void searchStudent(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("List of all students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Method to get the student list
    public List<Student> getStudentList() {
        return studentList;
    }
}

// Main class to test the StudentManagementSystem
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.searchStudent(rollToSearch);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
