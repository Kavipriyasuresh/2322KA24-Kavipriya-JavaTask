package session5;
import java.util.*;
import java.io.*;
public class post {
	    static ArrayList<String> studentNames = new ArrayList<>();
	    static HashMap<Integer, ArrayList<String>> studentCourses = new HashMap<>();
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n--- Mini Student Management App ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. Search Student by ID");
	            System.out.println("3. Delete Student");
	            System.out.println("4. Display All Students and Courses");
	            System.out.println("5. Save Courses to File");
	            System.out.println("6. Exit");
	            System.out.print("Choose: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1: addStudent(); break;
	                case 2: searchStudent(); break;
	                case 3: deleteStudent(); break;
	                case 4: displayAll(); break;
	                case 5: saveToFile(); break;
	                case 6: System.out.println("Goodbye!"); return;
	                default: System.out.println("Invalid choice.");
	            }
	        }
	    }

	    private static void addStudent() {
	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();
	        studentNames.add(name);
	        int id = studentNames.size(); // Simple ID assignment

	        System.out.print("Enter number of courses: ");
	        int count = scanner.nextInt();
	        scanner.nextLine();

	        ArrayList<String> courses = new ArrayList<>();
	        for (int i = 1; i <= count; i++) {
	            System.out.print("Enter course " + i + ": ");
	            courses.add(scanner.nextLine());
	        }

	        studentCourses.put(id, courses);
	        System.out.println("Student added with ID: " + id);
	    }

	    private static void searchStudent() {
	        System.out.print("Enter student ID to search: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        if (id <= 0 || id > studentNames.size()) {
	            System.out.println("Student not found.");
	            return;
	        }

	        String name = studentNames.get(id - 1);
	        ArrayList<String> courses = studentCourses.get(id);

	        System.out.println("Student Name: " + name);
	        System.out.println("Courses: " + courses);
	    }

	    private static void deleteStudent() {
	        System.out.print("Enter student ID to delete: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        if (id <= 0 || id > studentNames.size()) {
	            System.out.println("Invalid ID.");
	            return;
	        }

	        studentNames.set(id - 1, "[DELETED]");
	        studentCourses.remove(id);
	        System.out.println("Student removed.");
	    }

	    private static void displayAll() {
	        System.out.println("\n--- All Students ---");
	        for (int i = 0; i < studentNames.size(); i++) {
	            String name = studentNames.get(i);
	            if (!name.equals("[DELETED]")) {
	                System.out.println("ID: " + (i + 1) + ", Name: " + name);
	                ArrayList<String> courses = studentCourses.get(i + 1);
	                if (courses != null) {
	                    for (String course : courses) {
	                        System.out.println("   - " + course);
	                    }
	                }
	            }
	        }
	    }

	    private static void saveToFile() {
	        try {
	            File file = new File("output/courses.txt");
	            file.getParentFile().mkdirs();
	            PrintWriter writer = new PrintWriter(file);

	            for (int i = 0; i < studentNames.size(); i++) {
	                String name = studentNames.get(i);
	                if (!name.equals("[DELETED]")) {
	                    writer.println("ID: " + (i + 1) + ", Name: " + name);
	                    ArrayList<String> courses = studentCourses.get(i + 1);
	                    if (courses != null) {
	                        for (String course : courses) {
	                            writer.println("   - " + course);
	                        }
	                    }
	                }
	            }

	            writer.close();
	            System.out.println("Courses saved to output/courses.txt");
	        } catch (IOException e) {
	            System.out.println("Error saving file: " + e.getMessage());
	        }
	    }
	}


