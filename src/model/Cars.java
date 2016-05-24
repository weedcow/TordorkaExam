/**
 * 
 */
package model;

/**
 * @author Hans0707
 *
 */
public class Cars {
	int ID;
	String brand;
	String model;
	int price;
	int owner;
	public Test user;
	
	public Cars(int iD, Test user,String brand, String model, int price, int owner) {
		super();
		ID = iD;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.owner = owner;
		this.user = user;
		
	}

	public Test getUser() {
		return user;
	}

	public void setUser(Test user) {
		this.user = user;
	}

	public Cars(){
		super();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
}
