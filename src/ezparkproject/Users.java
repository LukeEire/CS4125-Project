package ezparkproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

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

	//Car reg plates list for the user, relating methods below
	ArrayList<String> plates = new ArrayList<String>();


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
		plates.add(reg);
		
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
	
	public void updateFirstName(String newFName) {
		this.firstName = newFName;
	}
	
	public void updateLastName(String newLName) {
		this.lastName = newLName;
	}
	
	public void updateEmail(String newEmail) {
		this.email = newEmail;
	}

	//add reg to user reg list
	public void addPlate(String reg){

		plates.add(reg);
		System.out.println("Added car reg: " + reg);
		System.out.println("Your vehicle number plates: ");
		System.out.println(plates);

	}

	//return list of reg plates for user
	public ArrayList<String> getPlates(){

		if (!plates.isEmpty()){
		
			return(plates);

		}else {

			System.out.println("No Reg plates found!");
			return(plates);

		}
		
	}

	//default reg plate is set as the first plate in the list and will automtically be the default when booking a parking space
	public void setDefaultPlate(String reg){
		System.out.println("Current Primary Vehicle set to: " + plates.get(0));
		plates.add(0, reg);
		System.out.println("Primary Vehicle set to: " + reg);
	}

	//returns default reg number for user
	public String getDefultPlate(){
		System.out.println("Primary Vehicle is: " + plates.get(0));
		return plates.get(0);
	}

	//deletes all reg numbers for the user
	public void clearPlates(){
		plates.clear();
		System.out.println("All Plates deleted");
	}
	
	
}