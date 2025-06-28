package session5;
import java.util.*;

class student {
    private String name;
    private int rollNo;

    public student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

   
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo;
    }

   
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return rollNo == s.rollNo && name.equalsIgnoreCase(s.name);
    }

   
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), rollNo);
    }
}

public class day5_main {

    private static ArrayList<Student> students = new ArrayList<>();
    private static HashMap<Student, ArrayList<String>> enrollmentMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Course Enrollment System ---");
            System.out.println("1. Add Student and Enroll Courses");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students and Courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: displayAll(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); 

        Student student = new Student(name, rollNo);

        if (students.contains(student)) {
            System.out.println("Student already exists!");
            return;
        }

        students.add(student);

        System.out.print("How many courses to enroll? ");
        int courseCount = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<String> courses = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(scanner.nextLine());
        }

        enrollmentMap.put(student, courses);
        System.out.println("Student and courses added successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter Roll No of student to remove: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); 

        Iterator<Student> iterator = students.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNo() == rollNo) {
                iterator.remove(); 
                enrollmentMap.remove(student); 
                found = true;
                System.out.println("Student removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }

        System.out.println("\n--- Enrolled Students and Courses ---");
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
            ArrayList<String> courses = enrollmentMap.get(student);

            if (courses != null && !courses.isEmpty()) {
                for (String course : courses) {
                    System.out.println("   - " + course);
                }
            } else {
                System.out.println("   No courses enrolled.");
            }
        }
    }
}

