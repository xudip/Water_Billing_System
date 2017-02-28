package includes;
//import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db_project";
	private static final String USER = "root";
	private static final String PWD = "";
	String username, password;

	@SuppressWarnings("finally")
	public static Connection makeConnetion(){
		Connection c = null;
		try{
			Class.forName(DRIVER);
			System.out.println("Load Driver: Successfull :D");
			c = DriverManager.getConnection(DB_URL, USER, PWD);
			System.out.println("Connection: Successful! :D");
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally
		{
			return(c);
		}
	}
	
	

}
