package ezparkproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

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
				
	
	public void blockForEvent(int duration, String lotName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime startBlock = now.plusDays(2);
		startBlock = startBlock.withHour(9);
		LocalDateTime endBlock = startBlock.plusHours(duration);
		
		
		
		
		//Take todays date and 2 days from now block reservations from 9am till duration of hours it up. 
		//Create sufficient reservations to fill the lot for that day
		 
	}
	
	
}



