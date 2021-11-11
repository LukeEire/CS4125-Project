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
	Database db;
	Connection con;

	
	public Users() {
		
	}

	public Users(int id, String firstName, String lastName, String password, String email, String status, int electric, int accessibility, String sdob) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.status = status;
		this.electric = electric;
		this.accessibility = accessibility;
		this.dob = sdob;

		Database db = new Database();

		try{

            con = db.connect();

        } catch(ClassNotFoundException e){

            System.out.println("Could not find the database driver " + e.getMessage());

        } catch(SQLException e1){

            System.out.println("Could not connect to the database " + e1.getMessage());

		}

		try {

			db.newUser(id, firstName, lastName, password, status, electric, accessibility, sdob);

		} catch (SQLException e) {

			e.printStackTrace();
			
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