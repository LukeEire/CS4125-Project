package ezparkproject;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdminBackend {
	
	
	
	
	/* Author:  Ashutosh Yadav  */
	
	AdminBackend() {
		
	}

	public static void fetchTransactionsFunction() throws Exception{
		try {
			Database db = new Database();
			db.fetchTransactionData();
		} catch (SQLException error) {
			System.out.println("Could not connect to the database " + error.getMessage());
		}
	}
	
	public static void fetchReservationFunction() throws Exception{
		

	
	try {
		
		Database db = new Database();
		
		db.fetchReservationData();
		
		
	} catch (SQLException error) {

		System.out.println("Could not connect to the database " + error.getMessage());

	}
}
	
	
	
	public static void unBanUserFunction(int id) {
		
		try {
			
			Database db = new Database();
			
			db.unBanUser(id);
			
			
			
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
	}
		
		
	public static boolean BanUserFunction(int id) {
		
		try {
			
			Database db = new Database();
			
			db.banUser(id);
			
			
			return true;
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		return true;
	}
		
		

	public static void deleteUserFunction(int id) throws Exception {
		
		try {
			
			Database db = new Database();
			
			db.deleteUser(id);
								
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		
	}
	
 
public static boolean verifyUserID(int id) throws SQLException{
		
    	try {
    		
    		Database db = new Database();
    		
    		
    		if (db.verifyUserID(id)) {
    			
                System.out.println("Account '" + id + "' found!");
                
                
                
            return true;   
                
    		
    		} else {
    			
    			
    			System.out.println("No account with user id: '" + id + "' found. Please double check your user id.");
    			
    		}
    		
    	} catch (SQLException error) {

    		System.out.println("Could not connect to the database " + error.getMessage());

    	}

    	
    	return false;
        
    }
				
	
	
}



