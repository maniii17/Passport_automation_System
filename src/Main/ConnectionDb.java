package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	public ConnectionDb() {
		connectDB();
	}
	public Connection connectDB() {
		try {
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/passportdb","root","1234");
			System.out.println("success");
			return conn;
		}
		catch(SQLException e) {
			
			System.out.println(e);
			Connection conn = null;
			return conn;
		}
	}
	
	
		
	}

		
