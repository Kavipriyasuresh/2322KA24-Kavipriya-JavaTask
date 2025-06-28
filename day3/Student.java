package session2;
import java.util.Scanner;
public class Student {
	
	    private String name;
	    private int rollNumber;
	    private int[] marks; 

	    public Student(String name, int rollNumber) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.marks = new int[3]; 
	    }
	    public void assignMarks(int mark1, int mark2, int mark3) {
	        marks[0] = mark1;
	        marks[1] = mark2;
	        marks[2] = mark3;
	    }

	    public int getTotalMarks() {
	        return marks[0] + marks[1] + marks[2];
	    }
	    public double getAverageMarks() {
	        return getTotalMarks() / 3.0;
	    }

	    public void displayResult() {
	        System.out.println("Student Name  : " + name);
	        System.out.println("Roll Number   : " + rollNumber);
	        System.out.println("Marks         : ");
	        System.out.println("  Subject 1   : " + marks[0]);
	        System.out.println("  Subject 2   : " + marks[1]);
	        System.out.println("  Subject 3   : " + marks[2]);
	        System.out.println("Total Marks   : " + getTotalMarks());
	        System.out.printf("Average Marks : %.2f\n", getAverageMarks());
	        System.out.println("Result        : " + (getAverageMarks() >= 40 ? "Pass" : "Fail"));
	    }
	



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int roll = scanner.nextInt();

        Student student = new Student(name, roll);

        
        System.out.println("Enter marks for 3 subjects:");
        System.out.print("Subject 1: ");
        int m1 = scanner.nextInt();
        System.out.print("Subject 2: ");
        int m2 = scanner.nextInt();
        System.out.print("Subject 3: ");
        int m3 = scanner.nextInt();

        student.assignMarks(m1, m2, m3);

        
        System.out.println("\n--- Student Result ---");
        student.displayResult();

        scanner.close();
    }
    }

