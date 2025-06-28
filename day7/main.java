package session7;
import java.sql.*;
import java.util.Scanner;

public class main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/product";
    static final String USER = "root";       
    static final String PASS = "kavi#2006";      

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connected to MySQL Database.");
            int choice;

            do {
                System.out.println("\n=== Student DB Manager ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter grade: ");
                        String grade = sc.nextLine();

                        String insertSQL = "INSERT INTO student (name, age, grade) VALUES (?, ?, ?)";
                        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                            stmt.setString(1, name);
                            stmt.setInt(2, age);
                            stmt.setString(3, grade);
                            stmt.executeUpdate();
                            System.out.println("Student added successfully.");
                        }
                        break;

                    case 2:
                        String selectSQL = "SELECT * FROM student";
                        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
                            System.out.println("\n--- Student List ---");
                            while (rs.next()) {
                                System.out.printf("ID: %d, Name: %s, Age: %d, Grade: %s\n",
                                        rs.getInt("id"), rs.getString("name"),
                                        rs.getInt("age"), rs.getString("grade"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new grade: ");
                        String newGrade = sc.nextLine();

                        String updateSQL = "UPDATE student SET name = ?, age = ?, grade = ? WHERE id = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
                            stmt.setString(1, newName);
                            stmt.setInt(2, newAge);
                            stmt.setString(3, newGrade);
                            stmt.setInt(4, updateId);
                            int rows = stmt.executeUpdate();
                            if (rows > 0) System.out.println("Student updated.");
                            else System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteSQL = "DELETE FROM student WHERE id = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(deleteSQL)) {
                            stmt.setInt(1, deleteId);
                            int rows = stmt.executeUpdate();
                            if (rows > 0) System.out.println("Student deleted.");
                            else System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }
}
