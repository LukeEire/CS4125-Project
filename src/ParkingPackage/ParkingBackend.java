package ParkingPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import ezparkproject.Database;

public class ParkingBackend {




	public ParkingBackend() 
	{

	}
	

	public static boolean checkID(int id) throws SQLException{

		try {

			Database db = new Database();


			if (db.checkID(id)) {

				System.out.println("Booking Number " + id + " Correct! Taking you to Payment!");
				 
           		return true;  

			} else {


				System.out.println("No booking ID: '" + id + "' found. Please double check your booking number please.");

			}

		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}


		return false;

	}
	


	

	public boolean validateCreditCard() {
		return false;
	}

	public double getTotalFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPaymentInformation(String ccNumber, String cvvNumber, String expiry) {
		// TODO Auto-generated method stub
		
	}


}

