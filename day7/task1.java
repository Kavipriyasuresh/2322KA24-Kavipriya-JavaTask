package session7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class task1 {
	public static void main(String[]args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/product";
		String username="root";
		String password ="kavi#2006";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		String Query="create table student(id int,name varchar(20),age int,grade int)";
		stmt.executeUpdate(Query);
		System.out.println("Table Create suceessfully");
	}
}

