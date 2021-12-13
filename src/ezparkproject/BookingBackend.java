package ezparkproject;

import java.sql.Connection;
/*import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;*/
import java.sql.SQLException;
import java.time.LocalDateTime;


public class BookingBackend {
	//Get this to handle changes to bookings
	
	Database db;
	Connection con;
	
//	 public static void main(String[] args) throws Exception{
//		 int count = 0;
//		 count = loadDbBookings("Lot A");
//		 System.out.println(count);
//		 
//	 }
	
	BookingBackend(){
		
	}
	
	public void decrementLotSpaces() {
		
	}
	
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
	
	public void decrementTest() {
		Main.LotA.setSpaces(Main.LotA.countSpaces()-1);
	}
	/*public void newDateForBooking(Date date,  ) {
		
	}*/
	
	/*public void connectToDB() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4448569","sql4448569", "rs5fNh4D5f");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/*public void makeBooking(Reservation res) {
		//LocalDateTime date = res.checkInDate;
		Users owner = res.getUser();
		int stayLength = res.duration;
		String lotOwner;
		
		//LocalDateTime expCheckout = date.plusHours(stayLength);
		
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

		try {
			String query = "INSERT INTO reservations(id, duration, checkInDate, checkOutDate, disability, electric ) VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, (res.getUser()).id);
			p.setInt(2, res.duration);
			p.setDate(3, res.checkInDate);
			p.setDate(4, res.checkOutDate);
			p.setInt(5, res.getUser().accessibility);
			p.setInt(6, res.getUser().electric);
			  
			  } catch (SQLException e) {
			  
			  e.printStackTrace();
			  
			  }
	}*/
	
	
}
