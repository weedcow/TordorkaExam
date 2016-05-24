package model;

import java.io.ObjectInputStream.GetField;

public class Test {
	int ID;
	String Username;
	String Password;
	
	public Test() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getUsername() {
		return Username;
	}

	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword(){
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}

	
	
	// For console output
	public String toString() {		
		return this.ID + " " + this.Username + " " + this.Password;
	}
	
	

}

