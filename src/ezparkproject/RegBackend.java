package ezparkproject;

import java.sql.SQLException;

public class RegBackend {

	// Author: Luke Kellet Murray, Ashutosh Yadav

	RegBackend(){
	
	}

	public void addUser(int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String dob, String reg) {
		
		//Remove email attribute from user object?
		Users User1 = new Users(true, id, firstName, lastName, password, "temp", status, electric, accessibility, dob, reg);
		
		try {
			
			Database db = new Database();
			db.newUser(User1);
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		
		
	}
	
	
	
}
