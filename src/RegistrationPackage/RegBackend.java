package RegistrationPackage;

import java.sql.SQLException;

import LoginPackage.LoginFunction;
import ezparkproject.Database;
import ezparkproject.Users;

public class RegBackend {

	// Author: Luke Kellet Murray, Ashutosh Yadav

	RegBackend(){
	
	}

	public boolean addUser(int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String dob, String reg) {
		
		Users User1 = new Users(id, firstName, lastName, password, "temp", status, electric, accessibility, dob, reg);
		
		try {
			
			Database db = new Database();
			LoginFunction frame = new LoginFunction();
            frame.setVisible(true);
            
			db.newUser(User1);
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		return true;
		
		
	}
	
	
	
}
