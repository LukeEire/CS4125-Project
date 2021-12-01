package ezparkproject;

import java.sql.SQLException;

// Pre-Condition - Passed value must be of type string
// Post-Condition - Verifies that email passed into this function is present in the Users Database
// Returns true if email are exists, false otherwise

public class ForgotPasswordBackend {
	
	ForgotPasswordBackend() {
		
	}
    
   
    public static boolean verifyEmail(String email) throws SQLException{
		
    	try {
    		
    		Database db = new Database();
    		
    		
    		if (db.verifyUserEmail(email)) {
    			
                System.out.print("Your account is valid");
                
                
                
            return true;   
                
    		
    		} else {
    			
    			
    			System.out.print("Your account doesn't exist");
    			
    		}
    		
    	} catch (SQLException error) {

    		System.out.println("Could not connect to the database " + error.getMessage());

    	}

    	
    	return false;
        
    }

}


/* Database db = new Database();
boolean result = db.verifyUserEmail(email);
return result; */