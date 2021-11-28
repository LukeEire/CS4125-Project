package ezparkproject;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdminBackend {
	
	
	
	
	// Author: Ashutosh Yadav 18249094
	
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
		
		
	public static void BanUserFunction(int id) {
		
		try {
			
			Database db = new Database();
			
			db.banUser(id);
			
			
			
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
	}
		
		

	public static void deleteUserFunction(int id) throws Exception {
		
		try {
			
			Database db = new Database();
			
			db.deleteUser(id);
								
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		
	}
	
	public static ArrayList<Users> fetchUserFunction() throws Exception {
		ArrayList<Users> users;
		
		try {
			
			Database db = new Database();
			
			users = db.fetchData();
			
			return users;
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());
			return null;

		}
		
	}


		
		
	
				
				
					
				
	
	
}



