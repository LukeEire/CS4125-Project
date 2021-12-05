package ezparkproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBackend {


	public PaymentBackend() 
	{

	}

	public static boolean checkLot(String lot) throws SQLException{

		try {

			Database db = new Database();


			if (db.checkLot(lot)) {

				System.out.println("Lot ID: " + lot + " Correct! Payment Successful!");
				 
           		return true;  

			} else {


				System.out.println("Lot ID: '" + lot + "' not found. Please double check your Lot number please.");

			}

		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}


		return false;

	}


}


