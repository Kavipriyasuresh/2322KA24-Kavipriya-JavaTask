package session7;
import java.sql.*;
import java.util.Scanner;

public class post {
    static final String DB_URL = "jdbc:mysql://localhost:3306/product";
    static final String USER = "root";     
    static final String PASS = "kavi#2006";     

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to Inventory DB");

            int choice;
            do {
                System.out.println("\n=== Inventory Menu ===");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Search Product");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();

                        String insertSQL = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                            stmt.setString(1, name);
                            stmt.setInt(2, qty);
                            stmt.setDouble(3, price);
                            stmt.executeUpdate();
                            System.out.println("Product added.");
                        }
                        break;

                    case 2:
                        String selectSQL = "SELECT * FROM products";
                        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
                            System.out.println("\n--- Product List ---");
                            while (rs.next()) {
                                System.out.printf("ID: %d | Name: %s | Qty: %d | Price: %.2f\n",
                                        rs.getInt("id"), rs.getString("name"),
                                        rs.getInt("quantity"), rs.getDouble("price"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Search by (1) ID or (2) Name? ");
                        int type = sc.nextInt();
                        sc.nextLine();
                        String searchSQL;
                        if (type == 1) {
                            System.out.print("Enter product ID: ");
                            int id = sc.nextInt();
                            searchSQL = "SELECT * FROM products WHERE id = ?";
                            try (PreparedStatement stmt = conn.prepareStatement(searchSQL)) {
                                stmt.setInt(1, id);
                                ResultSet rs = stmt.executeQuery();
                                if (rs.next()) {
                                    System.out.printf("ID: %d | Name: %s | Qty: %d | Price: %.2f\n",
                                            rs.getInt("id"), rs.getString("name"),
                                            rs.getInt("quantity"), rs.getDouble("price"));
                                } else {
                                    System.out.println("❌ Product not found.");
                                }
                            }
                        } else {
                            System.out.print("Enter product name: ");
                            String keyword = sc.nextLine();
                            searchSQL = "SELECT * FROM products WHERE name LIKE ?";
                            try (PreparedStatement stmt = conn.prepareStatement(searchSQL)) {
                                stmt.setString(1, "%" + keyword + "%");
                                ResultSet rs = stmt.executeQuery();
                                boolean found = false;
                                while (rs.next()) {
                                    found = true;
                                    System.out.printf("ID: %d | Name: %s | Qty: %d | Price: %.2f\n",
                                            rs.getInt("id"), rs.getString("name"),
                                            rs.getInt("quantity"), rs.getDouble("price"));
                                }
                                if (!found) {
                                    System.out.println("No products matched.");
                                }
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 4);

            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println(" Database Error:");
            e.printStackTrace();
        }
    }
}