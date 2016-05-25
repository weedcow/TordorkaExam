package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBconnect {
	
	public static Connection con;
	
	// Step 1: A static initialization block
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e1)
		{
			System.out.println("Driver not found " + e1);
		}
	}
	
	// Step 2: A method to create a connection (object) with the database
	public Connection getConnection() 
	{
		try
		{
			con = (Connection) DriverManager.getConnection(
			     "jdbc:mysql://web63.meebox.net:3306/hansmygi_cars", "hansmygi_user", "hemmelig123kode"); 
		}
		catch (SQLException e2)
		{
			System.out.println("No connection " + e2);
		}
		return con;
	}	
	
	// Step 6: A method to close the connection
	public void closeConnection(Connection con)
	{
		if (con != null)
			try
			{
				con.close();
			}
			catch (SQLException e3)
			{
				System.out.println("Problem on closing " + e3);
			}

	}
	
}
