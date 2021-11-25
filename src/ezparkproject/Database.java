package ezparkproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.sql.*;

/**
 * @author ayoubjdair
 * For easily accessing the DB and aids in the reduction of duplicate code
 * Methods for use in entire project
 */
public class Database {
	
	protected Connection con;
	protected String server;
	protected String username;
	protected String password;
	protected String users_db;
	protected String reservations_db;
	protected String url;
	protected int Port_number;
	protected String testVal;

	// Creates a Database object and connects to our Database
	public Database() throws SQLException{

		this.Port_number = 3306;
		this.reservations_db = "reservations";
		this.users_db = "users";
		this.server = "sql4.freesqldatabase.com:3306";
		this.username = "sql4450358";
		this.password = "dcCxqbDW1K";
		this.url = "jdbc:mysql://" + this.server +  "/" + this.username;
		this.con = DriverManager.getConnection(this.url, this.username, this.password);
		
	}
	
	// Returns a connection object
	// Prints Database Credential Details
	public Connection connect(){
		System.out.println("Sever: " + server);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("URL: " + url);
		System.out.println("Connection obj: " + con);
		return con;
	}

	// Returns ArrayList of type User with user collected from the DB
	// Prints User Details in DB
	public ArrayList<Users> fetchData() throws Exception{

		ArrayList<String> userIDs = new ArrayList<String>();
		ArrayList<Users> users = new ArrayList<Users>();
		int i = 0;
		try {

			String query = "select * from users";
	        PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);

			while(rs.next()){

				System.out.println("--------------------------User: "+i+"------------------------------");
				System.out.println("User ID: " + rs.getInt("id"));
				System.out.println("First name: " + rs.getString("firstName"));
				System.out.println("Last name: " + rs.getString("lastName"));
				System.out.println("Status: " + rs.getString("status"));
				System.out.println("Password: " + rs.getString("password"));
				System.out.println("Email: " + rs.getString("email_address"));
				System.out.println("Electric Car? [Y/N]: " + rs.getInt("electric"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
				System.out.println("Banned Status: " + rs.getInt("ban_status"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Created on: " + rs.getDate("created_on"));
				System.out.println("D.O.B: " + rs.getDate("dob"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Defualt Registration Plate: " + rs.getString("reg"));

				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				userIDs.add(rs.getString(1));

				Users collectedUser = new Users(false,
									   rs.getInt("id"),
									   rs.getString("firstName"),
									   rs.getString("lastName"),
									   rs.getString("password"),
									   rs.getString("email_address"),
									   rs.getString("status"),
									   rs.getInt("electric"),
									   rs.getInt("accessibility"),
									   rs.getDate("dob").toString(),
									   rs.getString("reg"));
				users.add(collectedUser);
			}
			
			System.out.println("Users ID's: ");
			System.out.println(userIDs);
			System.out.println();

			System.out.println("Users ArrayList: ");
			System.out.println(users);
			System.out.println();

			return users;
			
		} catch (Exception e) {
	    	System.out.println("Error fetching data: " + e.getMessage());
	    	return null;
		}
			
	}
	
	// INSERTS new user into the DB object
	public void newUser(int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String sdob, String reg) throws SQLException {

		// Converting string into sql date format
		Date dob = Date.valueOf(sdob);

		// Creates date obj created_at DB field
		LocalDate ld = LocalDate.now();
		// Converts date obj to sql format
		Date created_at = Date.valueOf(ld);

		// Generates user email automatically based on status
		String email = "NULL";
		if(status == "Student"){
			email = id + "@studentmail.ul.ie";
		} else if (status == "Staff") {
			email = id + "@ul.ie";
		} else {
			email = "N/A";
		}

		try {
			
			if(firstName!=null && status!=null && password!=null){
				
				//DB attributes
				// id
				// firstName 
				// firstName 
				// password
				// email_address 
				// status 
				// electric
				// penalties 
				// ban_status 
				// accessibility 
				// created_on 
				// dob
				// reg

				String query = "INSERT INTO " + users_db + "(id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob, reg ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";

				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, firstName);
				p.setString(3, lastName);
				p.setString(4, password);
				p.setString(5, email);
				p.setString(6, status);
				if(electric >= 1) {
		        	p.setInt(7, 1);
		        } else {
		        	p.setInt(7, 0);
		        }
				p.setInt(8, 0);
				p.setInt(9, 0);
				if(accessibility >= 1) {
		        	p.setInt(10, 1);
		        } else {
		        	p.setInt(10, 0);
		        }
				p.setDate(11, created_at);
				p.setDate(12, dob);
				p.setString(13, reg);
				
	            int insert = p.executeUpdate();
	            if(insert == 1)
	            {
	                System.out.println("New user added successfully");
	            }
	            else
	            {
	                System.out.println("FAIL! Error adding new user");
	            }
			}
		} catch (SQLException e){
			
	    	System.out.println("Error registering new user: " + e.getMessage());
			
		}
    }
	
	// DELETES user from user database
    public void deleteUser(int id) throws Exception {
    	
    	try {
    		
    		String query = "DELETE FROM " + users_db + " WHERE id = \""+id+"\"";
	        PreparedStatement p = con.prepareStatement(query);
	        int delete = p.executeUpdate(query);
	
	        if(delete == 1){
	        	System.out.println("User " + id + " removed successfully");
	        }
	        else{
	            System.out.println("FAIL: Deletion Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error deleting user: " + e.getMessage());

    	}
        
    }
	
	// UPDATES ban_status for user to 1 i.e TRUE 
    public void banUser(int id) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE " + users_db + " SET ban_status = 1 WHERE id = \""+id+"\"";
	        PreparedStatement p = con.prepareStatement(query);
	        int ban = p.executeUpdate(query);
	
	        if(ban == 1){
	        	System.out.println("User Banned Successfully");
	        }
	        else{
	            System.out.println("FAIL: Ban Failed");
	        }
	        
    	} catch (SQLException e){

    		System.out.println("Error banning user: " + e.getMessage());

    	}
    	
    }
		
	// UPDATES ban_status for user to 0 i.e FALSE 
	public void unBanUser(int id) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE " + users_db + " SET ban_status = 0 WHERE id = \""+id+"\"";
            PreparedStatement p = con.prepareStatement(query);
            int unBan = p.executeUpdate(query);

            if(unBan == 1){
            	System.out.println("User " + id + " Unbanned Successfully");
            }
            else{
                System.out.println("FAIL: unban Failed");
            }
	        
    	} catch (SQLException e){

    		System.out.println("Error unbanning user: " + e.getMessage());

    	}
    }
	
	// Verifies that the ID and PASSWORD passed into this function are present in the Users Database
	// Returns true if credentials are true
	public boolean verifyUser(int id, String password) throws SQLException {
		
		int checkUser = id;
		String checkPass = password;
		boolean result;
		
		try {
			
			String query = "SELECT * FROM " + users_db + " WHERE id = "+checkUser+" AND password = " + "\"" + checkPass + "\"";
			//String query = "SELECT * FROM users WHERE id = 18266404 AND password = \"Password123\"";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			
			if(!rs.isBeforeFirst()) {
				System.out.println("UserID OR password may be incorrect");
				System.out.println("User: "+ checkUser);
				System.out.println("Password: " + checkPass);
				result = false;
			} else {
				while (rs.next()) {
					int foundUser = rs.getInt("id");
					String foundPass = rs.getString("password");
					System.out.println("Found User: "+foundUser);
					System.out.println("User Password: "+foundPass);
				}
				result = true;
			}
			return result;
			
		} catch(SQLException e) {
									
			System.out.println("Error locating data entered: " + e.getMessage());
			result = false;
			return result;
			
		}
	}
	
	//Returns 0 for student, 1 for staff, 2 for guest
	public int getUserStatus(int id) throws SQLException{
		
		try {
			
			String query = "SELECT status FROM " + users_db + " WHERE id = ?";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			
			if(rs.getString(1) == "Student") {
				
				return 0;
				
			} else if (rs.getString(1) == "Staff") {
				
				return 1;
				
			} else if (rs.getString(1) == "Guest") {
				
				return 2;
				
			} else {
				
				System.out.println("Query returned: " + rs.getString(1));
				return 3;
			}
		} catch (SQLException e) {
			
			System.out.println("SQL error: " + e.getMessage());
			return 3;
		}
	}
	
	
	//Ayoub
	//Preliminary List of booking requirements (for reservations table): 
	//lmk if you wanna talk about adding or removing any
	// - USER ID
	// - Reservation ID
	// - Lot?
	// - Electric?
	// - Accessability?
	// - Expiry (Date entered for user to check out of parking space)

	// INSERTS new reservation into the resrvations DB
	public void reserve(int id, String reg, String lot, int electric, int accessibility, long hours, long mins) throws SQLException{
		// java.util.Date expiry = new Date(2000);
		// try {
		// 	expiry = new SimpleDateFormat("dd/MM/yyyy").parse(sexpiry);
		// } catch (ParseException e1) {
		// 	e1.printStackTrace();
		// } 

		// Variable for created_at field
		// LocalDate ca = LocalDate.now();
		// // Converting ca to sql date format
		// Date created_at = Date.valueOf(ca);

		try {

			DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime created_at_LocalDateTime = LocalDateTime.now();
			System.out.println("Resrvation Created At: " + created_at_LocalDateTime.format(simpleDateFormat));
			LocalDateTime expiryDateTime = created_at_LocalDateTime;
			// Convert from legacy class to modern class, an `Instant`, a point on the timeline in UTC with resolution of nanoseconds.
			expiryDateTime = expiryDateTime.plus(Duration.ofHours(hours));  
			expiryDateTime = expiryDateTime.plus(Duration.ofMinutes(mins));
			System.out.println("Resrvation expires: " + expiryDateTime.format(simpleDateFormat));
			//Converting ca & expiryDateTime to sql date format
			Date created_at = Date.valueOf(created_at_LocalDateTime.toLocalDate());
			Date expiry = Date.valueOf(expiryDateTime.toLocalDate());

			if(id > 0 && lot!=null){
				
				String query = "INSERT INTO " + reservations_db + "(userID, reg, lot, electric, accessibility, created_on, expiry) VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				//INSERT INTO reservations (userID, reg, lot, electric, accessibility, created_on, expiry) VALUES (18266401, '10LH1445', 'LOT A', 1, 0, DATE '2015-12-17', "01:15");

				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, reg);
				p.setString(3, lot);
				p.setInt(4, electric);
				p.setInt(5, accessibility);
				p.setDate(6, created_at);
				p.setDate(7, expiry);

		        if(electric >= 1) {
		        	p.setInt(4, 1);
		        } else {
		        	p.setInt(4, 0);
		        }
		        
		        if(accessibility >= 1) {
		        	p.setInt(5, 1);
		        } else {
		        	p.setInt(5, 0);
		        }
		        
	            int insert = p.executeUpdate(query);
	
	            if(insert == 1)
	            {
	                System.out.println("Reservation made successfully");
	            }
	            else
	            {
	                System.out.println("Reservation Failed");
	            }
			}
		} catch (SQLException e){
			
	    	System.out.println("Error reserving a spot: " + e.getMessage());
			
		}
    }
	

	// Prints Reservation Details in DB
	public void fetchReservationData() throws Exception{
		try {
			//Getting all DB data
			String query = "select * from " + reservations_db;
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			ArrayList<String> reservations = new ArrayList<String>();
			int i = 0;
			while(rs.next()){

				System.out.println("------------------------Reservation: "+i+"----------------------------");
				System.out.println("Reservations ID: " + rs.getInt("id"));
				System.out.println("User ID: " + rs.getInt("userID"));
				System.out.println("Registration Plate: " + rs.getString("reg"));
				System.out.println("Electric Car? [Y/N]: " + rs.getString("electric"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
				System.out.println("Reservation Date: " + rs.getDate("created_on"));
				System.out.println("Reserved until: " + rs.getDate("expiry"));
				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				reservations.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			
			System.out.println("Error fetching data: " + e.getMessage());
			
		}
			
	}


	// Returns ArrayList of type Reservations with reservation collected from the DB
	public ArrayList<Reservation> fetchUserReservation(Users user) throws Exception{
		try {
			//Getting all DB data
			String query = "select * from " + reservations_db + " WHERE userID = " + user.id;
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);

			ArrayList<Reservation> reservations = new ArrayList<Reservation>();

			while(rs.next()){

				int i = 0;
				System.out.println("------------------------Reservation: "+i+"----------------------------");
				System.out.println("Reservations ID: " + rs.getInt("id"));
				System.out.println("User ID: " + rs.getInt("userID"));
				System.out.println("Registration Plate: " + rs.getString("reg"));
				System.out.println("Electric Car? [Y/N]: " + rs.getString("electric"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
				System.out.println("Reservation Data: " + rs.getDate("created_on"));
				System.out.println("Reserved until: " + rs.getDate("expiry"));
				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				LocalDateTime reservationTimeDate = rs.getTimestamp("created_on").toLocalDateTime();
				LocalDateTime expiry = rs.getTimestamp("expiry").toLocalDateTime();
				
				Period durationPeriod = Period.between(reservationTimeDate.toLocalDate(), expiry.toLocalDate());
				String duration = durationPeriod.toString();
				System.out.println("Resrved for:  " + duration);


				Reservation collectedReservation = new Reservation(user, "N/A", duration );
				reservations.add(collectedReservation);
			}
			
			System.out.println("Reservations Arraylist: ");
			System.out.println(reservations);
			return reservations;
			
		} catch (Exception e) {
			
			System.out.println("Error fetching data: " + e.getMessage());
			return null;

		}
			
	}

//Luke Testing here
	//Probably need to update reservation object to have ID
	//Get list of booking requirements before messing with this
	public void newBooking(int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String sdob) throws SQLException {
		
		java.util.Date dob = new Date(2000);
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(sdob);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 

		LocalDate ca = LocalDate.now();
		Date created_at = Date.valueOf(ca);


		String email;
		if(status == "Student"){
			email = id + "@studentmail.ul.ie";
		} else if (status == "Staff") {
			email = id + "@ul.ie";
		} else {
			email = "N/A";
		}

		try {
			
			if(firstName!=null && status!=null && password!=null){
				
				//DB attributes
				// id
				// firstName 
				// firstName 
				// password
				// email_address 
				// status 
				// electric
				// penalties 
				// ban_status 
				// accessibility 
				// created_on 
				// dob

				String query = "INSERT INTO users (id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob ) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
				
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, firstName);
				p.setString(3, lastName);
				p.setString(4, password);
				p.setString(5, email);
				p.setString(6, status);
				// p.setInt(7, electric);
				p.setInt(8, 0);
				p.setInt(9, 0);
				// p.setInt(10, accessibility);
				p.setDate(11, created_at);
				p.setDate(12, (Date) dob);
		        
		        if(electric >= 1) {
		        	p.setInt(7, 1);
		        } else {
		        	p.setInt(7, 0);
		        }
		        
		        if(accessibility >= 1) {
		        	p.setInt(10, 1);
		        } else {
		        	p.setInt(10, 0);
		        }
		        
	            int insert = p.executeUpdate(query);
	
	            if(insert == 1)
	            {
	                System.out.println("New user added successful");
	            }
	            else
	            {
	                System.out.println("Insert Failed");
	            }
			}
		} catch (SQLException e){
			
	    	System.out.println("Error registering new user: " + e.getMessage());
			
		}
	}
}