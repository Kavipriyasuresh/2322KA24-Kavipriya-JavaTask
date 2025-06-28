package session7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class task2 {
	public static void main(String[]args) throws ClassNotFoundException, SQLException {  
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/product";
		String username="root";
		String password ="kavi#2006";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		String Query="insert into student values(1,'prem',20),(2,'Ram',25),(3,'kesaven',30),(4,'alex',40)";
		stmt.executeUpdate(Query);
		System.out.println("values Inserted Successfully");
	}
}
