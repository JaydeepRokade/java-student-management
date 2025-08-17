import java.util.*;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return id + " | " + name + " | " + course;
    }
}

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Course: "); String course = sc.nextLine();
        students.add(new Student(id, name, course));
        System.out.println("✅ Student added.");
    }

    static void viewStudents() {
        if (students.isEmpty()) System.out.println("No records found.");
        else students.forEach(System.out::println);
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: "); int id = sc.nextInt(); sc.nextLine();
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new Name: "); s.name = sc.nextLine();
                System.out.print("Enter new Course: "); s.course = sc.nextLine();
                System.out.println("✅ Updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: "); int id = sc.nextInt(); sc.nextLine();
        students.removeIf(s -> s.id == id);
        System.out.println("✅ Deleted if existed.");
    }
}
