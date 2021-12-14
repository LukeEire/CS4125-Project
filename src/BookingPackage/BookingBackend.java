package BookingPackage;
import ezparkproject.Main;

import java.sql.Connection;
/*import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;*/
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ezparkproject.Database;
//import ezparkproject.Main;


public class BookingBackend {
	Database db;
	Connection con;
	
	BookingBackend(){
		
	}
	
//	public void decrementLotSpaces() {
//		
//	}
	
	public String returnLot() {
		String temp;
		
		temp = Integer.toString(Main.LotA.countSpaces() - loadDbBookings("Lot A")) + ",";
		temp = temp + Integer.toString(Main.LotB.countSpaces() - loadDbBookings("Lot B")) + ",";
		temp = temp + Integer.toString(Main.LotC.countSpaces() - loadDbBookings("Lot C")) + ",";
		temp = temp + Integer.toString(Main.LotD.countSpaces() - loadDbBookings("Lot D"));
		
		return temp;
	}
	
	public void createBooking(Reservation res) {
		
		try {
			
			Database db = new Database();
			
			int ID = res.getUser().getID();
			String reg = res.getUser().getReg();
			String lot = res.getLot();
			int electric = res.getChargingCheck();
			int accessibility = res.getUser().getAcc();
			LocalDateTime startDate = res.getReservationTime();
			Long hours = res.getHours();
			
			
			
			db.reserve(ID, reg, lot, electric, accessibility, startDate, hours);
			
			if (lot == "Lot A") {
				Main.LotA.decrementSpaces(1);
			}else if (lot == "Lot B") {
				Main.LotB.decrementSpaces(1);
			}else if (lot == "Lot C") {
				Main.LotB.decrementSpaces(1);
			}else if (lot == "Lot D") {
				Main.LotB.decrementSpaces(1);
			}
			
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());

		}
		
	}
	
	public Reservation loadBooking(int id) {
		
		try {
			
			Database db = new Database();
			Reservation res = new PreBookReservation();
			
			res = db.fetchSingleReservation(id);
			
			
			return res;
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());
			return null;
		}
		
	}
	
	
	
	public ArrayList<String> loadBookingIDs(int userID) {
		ArrayList<Integer> bookingIDs = new ArrayList<Integer>();
		ArrayList<String> bookingData = new ArrayList<String>();
		
		try {
			
			Database db = new Database();
			bookingIDs = db.loadUsersBookings(userID);
			
		} catch (SQLException error) {
			System.out.println("Could not connect to the database " + error.getMessage());
		}
		
		if (bookingIDs.size() >= 1) {
			for (int i = 0; i < bookingIDs.size(); i++) {
				String value = "ID: " + (bookingIDs.get(i)).toString() + " Date: ";
				try {
					Database db = new Database();
					LocalDateTime dateLD = db.fetchSingleReservation(bookingIDs.get(i)).getReservationTime();
					Timestamp date = Timestamp.valueOf(dateLD);
					value = value + date + "\n";
					db.disconnect();
				}catch (SQLException error) {
					System.out.println("Could not connect to the database " + error.getMessage());
				}
				bookingData.add(value);
			}
		}
		return bookingData;
	}
	
	public static int loadDbBookings(String lotName) {
		int count = 0;
		try {
			
			Database db = new Database();
			count = db.checkExistingBookings(lotName);
			return count;
			
			
			
			
		} catch (SQLException error) {

			System.out.println("Could not connect to the database " + error.getMessage());
			return count;
		}
	}
	
	
}
