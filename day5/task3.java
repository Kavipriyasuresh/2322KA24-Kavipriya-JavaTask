package session5;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class task3 {
	    public static void main(String[] args) {
	        HashMap<String, Integer> studentMarks = new HashMap<>();
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = scanner.nextInt();
	        scanner.nextLine();
	        for (int i = 1; i <= n; i++) {
	            System.out.print("Enter name of student " + i + ": ");
	            String name = scanner.nextLine();

	            System.out.print("Enter marks of " + name + ": ");
	            int marks = scanner.nextInt();
	            scanner.nextLine(); 
	            studentMarks.put(name, marks);
	        }
	        System.out.println("\nStudent Marks:");
	        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }

	        int totalMarks = 0;
	        for (int marks : studentMarks.values()) {
	            totalMarks += marks;
	        }

	        double average = (double) totalMarks / studentMarks.size();
	        System.out.println("\nAverage Marks: " + average);

	        scanner.close();
	    }
	}