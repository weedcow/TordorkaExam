package dao;

import java.util.List;

import org.apache.catalina.User;

import com.mysql.jdbc.Connection;
import com.sun.org.apache.xpath.internal.operations.Bool;

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
					username.setEmail(rset.getString("email"));
					username.setFirstName(rset.getString("firstName"));
					username.setLastName(rset.getString("lastname"));
					username.setLevel(rset.getInt("level"));
					username.setPhone(rset.getString("phone"));
					username.setDeleted(rset.getInt("deleted"));
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
			sql = "SELECT * FROM cars WHERE deleted = 0";
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
				cars.setAircon(rset.getString("aircon"));
				cars.setDeleted(rset.getInt("deleted"));
				cars.setSeats(rset.getInt("seats"));
				cars.setGearbox(rset.getString("gearbox"));
				cars.setLuggage(rset.getInt("luggage"));
				cars.setReqAge(rset.getInt("reqAge"));
				cars.setDoors(rset.getInt("doors"));
				cars.setStatus(rset.getInt("status"));
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

	public Boolean createUser(String user, String pass, String email, String firstName, String lastName, String phone){
		
		
		con = connect.getConnection();
	      try
	      {
	    	  
	        // the mysql insert statement
	        sql = "INSERT INTO users (username, password, email, firstName, lastName, phone) VALUES (?, ?, ?, ?, ?, ?)";


	        PreparedStatement preparedStmt = con.prepareStatement(sql);
		      preparedStmt.setString (1, user);
		      preparedStmt.setString (2, pass);
		      preparedStmt.setString (3, email);
		      preparedStmt.setString (4, firstName);
		      preparedStmt.setString (5, lastName);
		      preparedStmt.setString (6, phone);
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
	public Test logIn(String user, String pass) {
		
		sql = "SELECT * FROM users WHERE username = ? AND password = ? AND deleted = 0";
		con = connect.getConnection();
		System.out.println(" Username "+ user + " password "+pass);
		
		 
		int userId = 0;
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, user);
	    	preparedStmt.setString (2, pass);
	    	ResultSet rset = preparedStmt.executeQuery();
	    	int count = 0;
	    	while(rset.next()) 
			{  
	    		count ++;
				String firstName = rset.getString("firstName").toString();
				
				userHolder.setUsername(rset.getString("username"));
				userHolder.setPassword(rset.getString("password"));
				userHolder.setID(rset.getInt("user_id"));
				userHolder.setEmail(rset.getString("email"));
				userHolder.setFirstName(rset.getString("firstName"));
				userHolder.setLastName(rset.getString("lastName"));
				userHolder.setPhone(rset.getString("phone"));
				userHolder.setLevel(rset.getInt("level"));
				System.out.println("the written user is : "+user);
				System.out.println("his access level is : " + userHolder.getLevel());
				System.out.println("the current database userholder is: "+ userHolder.getUsername());
				
				break;
			}
	    	if(count < 1)
	    	{
	    		 System.out.println("user does not exist");
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
		return userHolder;
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
	
	public Boolean createCar(String model, String brand, String price, String aircon, String seats, String gear, String doors, String luggage, String age)
	{
		sql = "INSERT INTO cars(brand, model, price, aircon, seats, gearbox, doors, luggage, reqAge) VALUES (?,?,?,?,?,?,?,?,?)";
		con = connect.getConnection();
		System.out.println("i am here" +model+brand+price);
		int resultCount = 0;
		
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, brand);
	    	preparedStmt.setString (2, model);
	    	preparedStmt.setString (3, price);
	    	preparedStmt.setString (4, aircon);
	    	preparedStmt.setString (5, seats);
	    	preparedStmt.setString (6, gear);
	    	preparedStmt.setString (7, seats);
	    	preparedStmt.setString (8, luggage);
	    	preparedStmt.setString (9, age);
	    	resultCount = preparedStmt.executeUpdate();
	    	
	    	
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		if(resultCount>0)
		{
    		return true;
    	}
		return false;
	}
	
	public Boolean updateCar(String model, String brand, String price, String aircon, String seats, String gearbox, String doors, String luggage, String age, String owner, String status, String deleted, String carId)
	{
		sql = "UPDATE cars SET car_id=?,brand=?,model=?,price=?, aircon=?, status=?, owner=?, seats=?,gearbox=?,doors=?,luggage=?,reqAge=?,deleted=? WHERE car_id = ?";
		con = connect.getConnection();
		System.out.println("i am here" +model+brand+price);
		int resultCount = 0;
		
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, carId);
		    preparedStmt.setString(2, brand);
	    	preparedStmt.setString (3, model);
	    	preparedStmt.setString (4, price);
	    	preparedStmt.setString (5, aircon);
	    	preparedStmt.setString(6, status);
	    	preparedStmt.setString(7, owner);
	    	preparedStmt.setString (8, seats);
	    	preparedStmt.setString (9, gearbox);
	    	preparedStmt.setString(10, doors);
	    	preparedStmt.setString (11, luggage);
	    	preparedStmt.setString (12, age);
	    	preparedStmt.setString (13, deleted);
	    	preparedStmt.setString(14, carId);
	    	resultCount = preparedStmt.executeUpdate();
	    	
	    	
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		if(resultCount>0)
		{
    		return true;
    	}
		return false;
	}
	
	public Boolean deleteCar(String carId)
	{
		
		sql = "UPDATE cars SET deleted=1 WHERE car_id = ?";
		con = connect.getConnection();
		int resultCount = 0;
		System.out.println("my ID is " + carId);
		
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, carId);
	    	resultCount = preparedStmt.executeUpdate();
	    	
	    	
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		if(resultCount>0)
		{
    		return true;
    	}
		return false;
	}
	
	public Boolean updateUser (String userId, String username, String password, String firstName, String lastName, String phone, String level, String deleted, String email)
	{
		sql = "UPDATE users SET user_id=?,username=?,password=?,email=?,firstName=?,lastName=?,phone=?,level=?,deleted=? WHERE user_id = ?";
		con = connect.getConnection();
		int resultCount = 0;
		
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, userId);
		    preparedStmt.setString(2, username);
	    	preparedStmt.setString (3, password);
	    	preparedStmt.setString(4, email);
	    	preparedStmt.setString (5, firstName);
	    	preparedStmt.setString (6, lastName);
	    	preparedStmt.setString(7, phone);
	    	preparedStmt.setString(8, level);
	    	preparedStmt.setString (9, deleted);
	    	preparedStmt.setString (10, userId);
	    	resultCount = preparedStmt.executeUpdate();
	    	
	    	
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		if(resultCount>0)
		{
    		return true;
    	}
		return false;
	}
	
	public Boolean deleteUser(String userId)
	{
		
		sql = "UPDATE users SET deleted=1 WHERE user_id = ?";
		con = connect.getConnection();
		int resultCount = 0;
		
		try
		{
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString (1, userId);
	    	resultCount = preparedStmt.executeUpdate();
	    	
	    	
		}
		catch (SQLException e4)
		{
			e4.printStackTrace();
		}
		finally
		{
			connect.closeConnection(con);
			
		}
		if(resultCount>0)
		{
    		return true;
    	}
		return false;
	}
	
	
}

