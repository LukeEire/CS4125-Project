package PasswordPackage;

import java.sql.SQLException;

import ezparkproject.Database;

// Pre-Condition - Passed value must be of type string
// Post-Condition - Verifies that email passed into this function is present in the Users Database
// Returns true if email are exists, false otherwise


/* Authors: Ashutosh Yadav and Ayoub Jdair */

public class ForgotPasswordBackend {
	
	ForgotPasswordBackend() {
		
	}
    
   
    public static boolean verifyEmail(String email) throws SQLException{
		
    	try {
    		
    		Database db = new Database();
    		
    		
    		if (db.verifyUserEmail(email)) {
    			
                System.out.println("Account '" + email + "' found!");
                
                
                
            return true;   
                
    		
    		} else {
    			
    			
    			System.out.println("No account with email: '" + email + "' found. Please double check your email address.");
    			
    		}
    		
    	} catch (SQLException error) {

    		System.out.println("Could not connect to the database " + error.getMessage());

    	}

    	
    	return false;
        
    }

}

