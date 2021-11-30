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
	
	public static String fetchUserFunction() {
		ArrayList<Users> users;
		
		try {
			
			Database db = new Database();
			
			users = db.fetchData();
			String output = "";
			
			
			for (int i =0 ; i < users.size(); i++){
				output = output + "--------------------------User: "+ users.get(i).getID()+ "------------------------------" + System.lineSeparator();
				output = output + "User ID: " + users.get(i).getID() +System.lineSeparator();
				
				
				
			}
			
			/*
			System.out.println("User ID: " + rs.getInt("id"));
			System.out.println("First name: " + rs.getString("firstName"));
			System.out.println("Last name: " + rs.getString("lastName"));
			System.out.println("Status: " + rs.getString("status"));
			System.out.println("Password: " + rs.getString("password"));
			System.out.println("Email: " + rs.getString("email_address"));
			System.out.println("Electric Car? [Y/N]: " + rs.getInt("electric"));
			System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
			System.out.println("Banned Status: " + rs.getInt("ban_status"));
			System.out.println("Ban Time: " + rs.getDate("banTime"));
			System.out.println("Penalty Points: " + rs.getInt("penalties"));
			System.out.println("Created on: " + rs.getDate("created_on"));
			System.out.println("D.O.B: " + rs.getDate("dob"));
			System.out.println("Penalty Points: " + rs.getInt("penalties"));
			System.out.println("Default Registration Plate: " + rs.getString("reg"));

			System.out.println("-----------------------------END-------------------------------");*/
			
			
			
			return output;
			
		} catch (Exception error) {

			System.out.println("Could not connect to the database " + error.getMessage());
			return null;

		}
		
	}


		
		
	
				
				
					
				
	
	
}



