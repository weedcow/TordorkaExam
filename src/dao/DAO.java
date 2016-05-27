package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.util.StringParser;

import model.*;

public interface DAO {
	
	//
	public List<Test> getUsernames();
	public List<Cars> getCars();
	public Test logIn(String username, String password);
	public Boolean buyCar(int carId, int userId);
	public Boolean createUser(String username, String password, String email, String firstName, String lastName, String phone);
	public void returnSpecificCar(int carId);
	public Boolean createCar (String model, String brand, String price, String aircon, String seats, String gear, String doors, String luggage, String age);
	public Boolean updateCar (String model, String brand, String price, String aircon, String seats, String gearbox, String doors, String luggage, String age, String owner, String status, String deleted, String carId);
	public Boolean deleteCar (String carId);
	public Boolean updateUser (String userId, String username, String password, String firstName, String lastName, String phone, String level, String deleted, String email);
	public Boolean deleteUser (String userId);
}