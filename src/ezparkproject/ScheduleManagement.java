package ezparkproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScheduleManagement {
	//Get this to handle changes to bookings
	
	
	Lot LotA = new Lot ("LotA", 300, 10, 3);
	Lot LotB = new Lot ("LotB", 350, 15, 0);
	Lot LotC = new Lot ("LotC", 300, 15, 5);
	Lot LotD = new Lot ("LotD", 400, 20, 10);
	
	
	public void newDateForBooking(Date date,  ) {
		
	}
	
	public void connectToDB() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4448569","sql4448569", "rs5fNh4D5f");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
