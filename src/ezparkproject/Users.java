package ezparkproject;

import java.sql.Connection;
import java.sql.SQLException;

public class Users {
	
	int id;
	String firstName;
	String lastName;
	String password;
	String email;
	String status;
	int electric;
	int accessibility; 
	String dob;
	String reg;
	Database db;
	Connection con;
	
	public Users() {
		
	}

	public Users(boolean addUserToDatabase, int id, String firstName, String lastName, String password, String email, String status, int electric, int accessibility, String sdob, String reg) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.status = status;
		this.electric = electric;
		this.accessibility = accessibility;
		this.dob = sdob;
		this.reg = reg;
		
		if (addUserToDatabase) {

			try {
				Database db = new Database();
				db.newUser(id, firstName, lastName, password, status, electric, accessibility, sdob, reg);
	
			} catch (SQLException e) {
	
				System.out.println("Could not connect to the database " + e.getMessage());
				
			}
			
		}
		
		
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getsDOB() {
		return this.dob;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getReg() {
		return this.reg;
	}
	
	public int getElec() {
		return this.electric;
	}
	
	public int getAcc() {
		return this.accessibility;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setsDOB(String dob) {
		this.dob = dob;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setReg(String reg) {
		this.reg = reg;
	}
	
	public void setElectric(int electric) {
		this.electric = electric;
	}
	
	public void setAccesibility(int access) {
		this.accessibility = access;
	}
	
	public void updateFirstName(String newFName) {
		this.firstName = newFName;
	}
	
	public void updateLastName(String newLName) {
		this.lastName = newLName;
	}
	
	public void updateEmail(String newEmail) {
		this.email = newEmail;
	}
	
}