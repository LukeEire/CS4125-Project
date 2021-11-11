package ezparkproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ScheduleManagement {
	//Get this to handle changes to bookings
	
	
	Lot LotA = new Lot ("LotA", 300, 10, 3);
	Lot LotB = new Lot ("LotB", 350, 15, 0);
	Lot LotC = new Lot ("LotC", 300, 15, 5);
	Lot LotD = new Lot ("LotD", 400, 20, 10);
	
	Database db;
	Connection con;
	
	
	/*public void newDateForBooking(Date date,  ) {
		
	}*/
	
	public void connectToDB() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4448569","sql4448569", "rs5fNh4D5f");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void makeBooking(Reservation res) {
		LocalDateTime date = res.checkInDate;
		Users owner = res.getUser();
		int stayLength = res.duration;
		String lotOwner;
		
		LocalDateTime expCheckout = date.plusHours(stayLength);
		
		//Do we need a section where they select the Lot or is it randomly assigned
		int tempS = 0;
		if (LotA.spaces < LotB.spaces) {
			tempS = LotB.spaces;
		}
		if (tempS < LotC.spaces) {
			tempS = LotC.spaces;
		}
		if (tempS < LotD.spaces) {
			tempS = LotD.spaces;
		}
		
		//Connect to DB here
		Database db = new Database();

		try{

            con = db.connect();

        } catch(ClassNotFoundException e){

            System.out.println("Could not find the database driver " + e.getMessage());

        } catch(SQLException e1){

            System.out.println("Could not connect to the database " + e1.getMessage());

		}

		/*
		 * try {
		 * 
		 * //db.(id, firstName, lastName, password, status, electric, accessibility,
		 * sdob);
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */
		
		
		
	}
}
