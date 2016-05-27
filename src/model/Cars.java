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
	String Brand;
	String Model;
	int Price;
	int Status;
	int Owner;
	String Aircon;
	int Seats;
	String Gearbox;
	int Doors;
	int Luggage;
	int ReqAge;
	int Deleted;
	
	public Test User;
	
	public Cars(int id, Test user,String brand, String model, int price, int owner, int status, int doors, int luggage, int reqAge, int deleted, String gearbox, String aircon) {
		super();
		this.ID = id;
		this.Brand = brand;
		this.Model = model;
		this.Price = price;
		this.Owner = owner;
		this.Status = status;
		this.Doors = doors;
		this.Luggage = luggage;
		this.ReqAge = reqAge;
		this.Deleted = deleted;
		this.Aircon = aircon;
		this.Gearbox = gearbox;
		this.User = user;
		
	}

	public Test getUser() {
		return User;
	}

	public void setUser(Test user) {
		this.User = user;
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
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getOwner() {
		return Owner;
	}

	public void setOwner(int userId) {
		Owner = userId;
	}

	public String getAircon() {
		return Aircon;
	}

	public void setAircon(String aircon) {
		Aircon = aircon;
	}

	public int getSeats() {
		return Seats;
	}

	public void setSeats(int seats) {
		Seats = seats;
	}

	public String getGearbox() {
		return Gearbox;
	}

	public void setGearbox(String gearbox) {
		Gearbox = gearbox;
	}

	public int getDoors() {
		return Doors;
	}

	public void setDoors(int doors) {
		Doors = doors;
	}

	public int getLuggage() {
		return Luggage;
	}

	public void setLuggage(int luggage) {
		Luggage = luggage;
	}

	public int getReqAge() {
		return ReqAge;
	}

	public void setReqAge(int reqAge) {
		ReqAge = reqAge;
	}

	public int getDeleted() {
		return Deleted;
	}

	public void setDeleted(int deleted) {
		Deleted = deleted;
	}
	
	
	
}
