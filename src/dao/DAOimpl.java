package dao;

import java.util.List;

import org.apache.catalina.User;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.DBconnect;

import model.*;

public class DAOimpl implements DAO{
	
	public static Connection con;
	public static Statement st;
	public static PreparedStatement prst;
	public static String sql;
	public static ResultSet rset;
	public static ResultSet rset2;
	
	List<Test> usernameHolder = new ArrayList<Test>();
	List<Cars> carsHolder = new ArrayList<Cars>();
	Test userHolder = new Test();
	DBconnect connect = new DBconnect();
	
	public List<Test> getUsernames()
		{
			sql = "SELECT * FROM users";
			con = connect.getConnection();
			try
			{
				st = con.createStatement();
				rset =  st.executeQuery(sql);
				while(rset.next()) 
				{  
					Test username = new Test();
					username.setID(rset.getInt("user_id"));
					username.setUsername(rset.getString("username"));
					username.setPassword(rset.getString("password"));
					System.out.println("DAOimpl: "+username);
					usernameHolder.add(username);
				}
			}
			catch (SQLException e4)
			{
				e4.printStackTrace();
			}
			finally
			{
				connect.closeConnection(con);
			}
			return usernameHolder;
		}
	
		
	public List<Cars> getCars()
	{
		sql = "SELECT * FROM cars";
		con = connect.getConnection();
		try
		{
			sql = "SELECT * FROM cars";
			st = con.createStatement();
			rset =  st.executeQuery(sql);
			while(rset.next()) 
			{  
				
				
				Cars cars = new Cars();
				cars.setID(rset.getInt("car_id"));
				cars.setBrand(rset.getString("brand"));
				cars.setModel(rset.getString("model"));
				cars.setPrice(rset.getInt("price"));
				cars.setOwner(rset.getInt("owner"));
				if(rset.getInt("owner") != 0){
					Test userOwner = carsOwner(rset.getInt("owner"));
					cars.setUser( userOwner );
				}
				else{
					Test userOwner = new Test();
					userOwner.setUsername("No one");
					cars.setUser(userOwner);
				}
				System.out.println("DAOimpl: "+cars);
				carsHolder.add(cars);
				
			}
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
		}
		return carsHolder;
	}
	
	public Test carsOwner (int owner){
		Test userOwner = new Test();
		
		
		
		try
		{
			
			st = con.createStatement();
			rset2 = st.executeQuery("SELECT * FROM users WHERE user_id = "+owner);
			while(rset2.next()) 
			{  
				userOwner.setUsername(rset2.getString("username"));
			}
				
				System.out.println("DAOimplUserowner"+ userOwner);
		}
				
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			
		}
		
		return userOwner;
	}

	public Boolean createUser(String user, String pass){
		
		
		con = connect.getConnection();
	      try
	      {
	    	  System.out.println("Username is "+ user+ " and password is " + pass);
	        // the mysql insert statement
	        sql = "INSERT INTO users (username, password) VALUES (?, ?)";


	        PreparedStatement preparedStmt = con.prepareStatement(sql);
		      preparedStmt.setString (1, user);
		      preparedStmt.setString (2, pass);
		      preparedStmt.executeUpdate();
		     con.close();
	       return true;
	      }
	      catch (Exception e)
	      {
	    	  
	        System.err.println("Got an exception!");
	        System.err.println(e.getMessage());
	      }
	      return false;
		
		
	}

	@Override
	public int logIn(String user, String pass) {
		
		sql = "SELECT * FROM users";
		con = connect.getConnection();
		System.out.println(" Username "+ user + " password "+pass);
		int userId = 0;
		try
		{
			st = con.createStatement();
			rset =  st.executeQuery(sql);
			while(rset.next()) 
			{  
				String str1 = rset.getString("username").toString();
				String str2 = user;
				userHolder.setUsername(rset.getString("username"));
				userHolder.setPassword(rset.getString("password"));
				userHolder.setID(rset.getInt("user_id"));
				System.out.println("the written user is : "+user);
				System.out.println("the current database userholder is: "+ userHolder.getUsername());
				if(str2.equals(str1)){
					//userHolder.getUsername() == user
					System.out.println("found user ");
					userId = userHolder.getID();
					System.out.println("The userId is  "+userId);
					break;
					
				}else{
					System.out.println("user not found");
				}
			}
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		return userId;
	}
	
	public Boolean buyCar(int userId, int carId){
		sql = "UPDATE cars SET owner = ? WHERE car_id= ?";
		con = connect.getConnection();
		try
		{
			sql = "UPDATE cars SET owner = ? WHERE car_id= ?";
			PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, carId);
            pst.setInt(2, userId);
            pst.executeUpdate();
			
			System.out.println("Updated car owner.");
				
			
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
		}
		
		return false;
	}
	public void returnSpecificCar(int carId){
		sql = "UPDATE cars SET owner = 0 WHERE car_id= ?";
		con = connect.getConnection();
		try
		{
			PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, carId);
            pst.executeUpdate();
			
			System.out.println("Returned the car!");
				
			
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
		}
		
		
	}

}