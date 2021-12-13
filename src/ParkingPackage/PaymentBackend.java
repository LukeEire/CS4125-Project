package ParkingPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ezparkproject.Database;

public class PaymentBackend {

	static double cost = 1.50; // default cost
	static double ppoints = 2.00; // penalty points cost
	static double PAP = ppoints * 2.00; // payment after penalty points
	
	public PaymentBackend() 
	{
		
	}

	public static boolean checkTime(String created_on, String expiry) throws SQLException{

		try {

			Database db = new Database();


			if (db.checkTime(created_on, expiry)) {

				JOptionPane.showMessageDialog(null, "Started Parking at: " + created_on + "until" + expiry);
				System.exit(0);
           		return true;  

			} else {


				JOptionPane.showMessageDialog(null, "Please double check inputs.");

			}

		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		return false;
	}
	
	
	
	

	
	

}


