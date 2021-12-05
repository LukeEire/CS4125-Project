package ezparkproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBackend {


	public PaymentBackend() 
	{

	}

	public static boolean checkTime(int created_on) throws SQLException{

		try {

			Database db = new Database();


			if (db.checkTime(created_on)) {

				System.out.println("Booking Number " + created_on + " Correct! Taking you to Payment!");
				 
           		return true;  

			} else {


				System.out.println("No booking ID: '" + created_on + "' found. Please double check your booking number please.");

			}

		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}


		return false;

	}


}


