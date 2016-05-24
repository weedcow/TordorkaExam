package dao;

import java.sql.SQLException;
import java.util.List;

import model.*;

public interface DAO {
	
	//
	public List<Test> getUsernames();
	public List<Cars> getCars();
	public int logIn(String username, String password);
	public Boolean buyCar(int carId, int userId);
	public Boolean createUser(String username, String password);
	public void returnSpecificCar(int carId);
}