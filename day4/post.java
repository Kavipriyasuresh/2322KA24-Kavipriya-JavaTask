package session4;
import java.io.*;
import java.util.*;
public class post {

	    static final String FILE_NAME = "employee.txt";

	    public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n--- Employee Record System ---");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View All Employees");
	            System.out.println("3. Search Employee by ID");
	            System.out.println("4. Update Employee");
	            System.out.println("5. Delete Employee");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 -> addEmployee(sc);
	                case 2 -> viewEmployees();
	                case 3 -> searchEmployee(sc);
	                case 4 -> updateEmployee(sc);
	                case 5 -> deleteEmployee(sc);
	                case 6 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid choice!");
	            }
	        } while (choice != 6);
	    }

	    public static void addEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter ID: ");
	        String id = sc.nextLine();
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Department: ");
	        String dept = sc.nextLine();
	        System.out.print("Enter Salary: ");
	        String salary = sc.nextLine();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
	        writer.write(id + "," + name + "," + dept + "," + salary);
	        writer.newLine();
	        writer.close();
	        System.out.println("Employee added.");
	    }
	    public static void viewEmployees() throws IOException {
	        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
	        String line;
	        System.out.println("\n--- Employee List ---");
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            System.out.println("ID: " + parts[0] + ", Name: " + parts[1] +
	                               ", Dept: " + parts[2] + ", Salary: " + parts[3]);
	        }
	        reader.close();
	    }
	    public static void searchEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID to search: ");
	        String targetId = sc.nextLine();
	        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
	        String line;
	        boolean found = false;

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts[0].equals(targetId)) {
	                System.out.println("Found -> ID: " + parts[0] + ", Name: " + parts[1] +
	                                   ", Dept: " + parts[2] + ", Salary: " + parts[3]);
	                found = true;
	                break;
	            }
	        }
	        reader.close();
	        if (!found) System.out.println("Employee not found.");
	    }
	    public static void updateEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID to update: ");
	        String targetId = sc.nextLine();

	        File inputFile = new File(FILE_NAME);
	        File tempFile = new File("temp.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String line;
	        boolean updated = false;

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts[0].equals(targetId)) {
	                System.out.print("Enter New Name: ");
	                String name = sc.nextLine();
	                System.out.print("Enter New Dept: ");
	                String dept = sc.nextLine();
	                System.out.print("Enter New Salary: ");
	                String salary = sc.nextLine();

	                writer.write(targetId + "," + name + "," + dept + "," + salary);
	                updated = true;
	            } else {
	                writer.write(line);
	            }
	            writer.newLine();
	        }

	        writer.close();
	        reader.close();

	        inputFile.delete();
	        tempFile.renameTo(inputFile);

	        if (updated) System.out.println("Employee updated.");
	        else System.out.println("Employee ID not found.");
	    }
	    public static void deleteEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID to delete: ");
	        String targetId = sc.nextLine();

	        File inputFile = new File(FILE_NAME);
	        File tempFile = new File("temp.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String line;
	        boolean deleted = false;

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts[0].equals(targetId)) {
	                deleted = true;
	                continue; 
	            }
	            writer.write(line);
	            writer.newLine();
	        }

	        writer.close();
	        reader.close();

	        inputFile.delete();
	        tempFile.renameTo(inputFile);

	        if (deleted) System.out.println("Employee deleted.");
	        else System.out.println("Employee ID not found.");
	    }
	}


