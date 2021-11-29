package ezparkproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

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
	protected String transactions_db;
	protected String reservations_db;
	protected String url;
	protected int port_number;
	protected String testVal;

	// Creates a Database object and connects to our Database
	public Database() throws SQLException{

		this.reservations_db = "reservations";
		this.transactions_db = "transactions";
		this.users_db = "users";
		this.server = "sql4.freesqldatabase.com";
		this.username = "sql4450358";
		this.password = "dcCxqbDW1K";
		this.port_number = 3306;
		//jdbc:mysql://"sql4.freesqldatabase.com:3306/sql4450358
		this.url = "jdbc:mysql://" + this.server + ":" + this.port_number + "/" + this.username;
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

	// Admin function
	// Passed in table will be cleared of all entries
	public void clearTable(String tableName){
		try {
    		
			String query = "TRUNCATE TABLE " + tableName;
	        PreparedStatement p = con.prepareStatement(query);
	        int dropped = p.executeUpdate(query);
	
	        if(dropped == 1){
	        	System.out.println(tableName + " cleared successfully");
	        }
	        else{
	            System.out.println("FAIL: Clear Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error clearing table: " + e.getMessage());

    	}
	}

	// Admin function
	// Passed in table will be DROPPED from the DB
	public void dropTable(String tableName){
		try {
    		
			String query = "DROP TABLE " + tableName;
	        PreparedStatement p = con.prepareStatement(query);
	        int dropped = p.executeUpdate(query);
	
	        if(dropped == 1){
	        	System.out.println(tableName + " Dropped successfully");
	        }
	        else{
	            System.out.println("FAIL: Deletion Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error dropping table: " + e.getMessage());

    	}
	}

	// Admin function
	// CREATES users table
	public void createUsersTable(){
		try {
    		
			String query = "CREATE TABLE IF NOT EXISTS users " +
							" ( id int(32) PRIMARY KEY, " +
							" firstName VARCHAR(255) NOT NULL, " +
							" lastName VARCHAR(255) NOT NULL, " +
							" password VARCHAR(255), " +
							" email_address VARCHAR(320), " +
							" status VARCHAR(32), " +
							" electric TINYINT(1), " +
							" penalties int(11), " +
							" ban_status TINYINT(1), " +
							" banTime DATE, " +
							" accessibility TINYINT(1), " +
							" created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
							" dob DATE, " +
							" reg VARCHAR(255) " +
							" );";

	        PreparedStatement p = con.prepareStatement(query);
	        int dropped = p.executeUpdate(query);
	
	        if(dropped == 1){
	        	System.out.println("TABLE: users CREATED successfully");
	        }
	        else{
	            System.out.println("FAIL: CREATION Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error CREATING table: " + e.getMessage());

    	}
	}

	// Admin function
	// CREATES reservations table
	public void createReservationsTable(){
		try {
    		
			String query = "CREATE TABLE IF NOT EXISTS reservations " +
							" ( id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,	" +
							" userID int(32) NOT NULL, " +
							" reg VARCHAR(255) NOT NULL, " +
							" lot varchar(255) NOT NULL, " +
							" electric TINYINT(1), " +
							" accessibility TINYINT(1), " +
							" created_on DATE, " +
							" expiry DATE, " +
							" FOREIGN KEY (userID) REFERENCES users(id) " +
							" );";

	        PreparedStatement p = con.prepareStatement(query);
	        int dropped = p.executeUpdate(query);
	
	        if(dropped == 1){
	        	System.out.println("TABLE: reservations CREATED successfully");
	        }
	        else{
	            System.out.println("FAIL: CREATION Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error CREATING table: " + e.getMessage());

    	}
	}

	// Admin function
	// CREATES transactions table
	public void createTransactionsTable(){
		try {
    		
			String query = "CREATE TABLE IF NOT EXISTS transactions " +
							" ( id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,	" +
							" userID int(32) NOT NULL, " +
							" reservationsID int(32) NOT NULL, " +
							" lot varchar(255) NOT NULL, " +
							" amount double NOT NULL, " +
							" created_on DATE, " +
							" created_on DATE, " +
							" FOREIGN KEY (userID) REFERENCES users(id)," +
							" FOREIGN KEY (reservationsID) REFERENCES reservations(id) " +
							" );";

	        PreparedStatement p = con.prepareStatement(query);
	        int dropped = p.executeUpdate(query);
	
	        if(dropped == 1){
	        	System.out.println("TABLE: transactions CREATED successfully");
	        }
	        else{
	            System.out.println("FAIL: CREATION Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error CREATING table: " + e.getMessage());

    	}
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
				System.out.println("Ban Time: " + rs.getDate("banTime"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Created on: " + rs.getDate("created_on"));
				System.out.println("D.O.B: " + rs.getDate("dob"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Default Registration Plate: " + rs.getString("reg"));

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
		LocalDateTime ld = LocalDateTime.now();
		// Converts date obj to sql format
		Date created_at = Date.valueOf(ld.toLocalDate());

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

				String query = "INSERT INTO " + users_db + "(id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob, reg ) VALUES (?, ?, ?, MD5(?), ?, ?, ?, ?, ? ,?, ?, ?, ?)";

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
	
	public void newUser(Users user1) throws SQLException {

		// Converting string into sql date format
		Date dob = Date.valueOf(user1.getsDOB());

		// Creates date obj created_at DB field
		LocalDate ld = LocalDate.now();
		// Converts date obj to sql format
		Date created_at = Date.valueOf(ld);

		// Generates user email automatically based on status
		String email = "NULL";
		if(user1.getStatus() == "Student"){
			email = user1.getID() + "@studentmail.ul.ie";
		} else if (user1.getStatus() == "Staff") {
			email = user1.getID() + "@ul.ie";
		} else {
			email = "N/A";
		}

		try {
			
			if(user1.getFirstName() !=null && user1.getStatus() != null && user1.getPassword() != null){
				
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
				p.setInt(1, user1.getID());
				p.setString(2, user1.getFirstName());
				p.setString(3, user1.getLastName());
				p.setString(4, user1.getPassword());
				p.setString(5, email);
				p.setString(6, user1.getStatus());
				if(user1.getElec() >= 1) {
		        	p.setInt(7, 1);
		        } else {
		        	p.setInt(7, 0);
		        }
				p.setInt(8, 0);
				p.setInt(9, 0);
				if(user1.getAcc() >= 1) {
		        	p.setInt(10, 1);
		        } else {
		        	p.setInt(10, 0);
		        }
				p.setDate(11, created_at);
				p.setDate(12, dob);
				p.setString(13, user1.getReg());
				
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
	
	public Users getUser(int id) throws Exception {
		
		Users user = new Users();
		
		try {
			String query = "SELECT * FROM " + users_db + " WHERE id= ?";
			
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, id);
			
			
			 ResultSet rs = p.executeQuery();
		        if (rs.next())
		        {
		        	user.setID(rs.getInt("id"));
		        	user.setFirstName(rs.getString("firstName"));
		        	user.setLastName(rs.getString("lastName"));
		        	user.setPassword(rs.getString("password"));
		        	user.setEmail(rs.getString("email_address"));
		        	user.setStatus(rs.getString("status"));
		        	user.setElectric(rs.getInt("electric"));
		        	//If theres an error check spelling
		        	user.setAccesibility(rs.getInt("accessibility"));
		        	user.setsDOB(rs.getString("dob"));
		        	user.setReg(rs.getString("reg"));
		        }
			
		} catch (SQLException e){
			
		}
		
		
		return user;
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
	// UPDATES banTime to one week from now
    public void banUser(int id) throws SQLException{
		
		LocalDateTime now = LocalDateTime.now();
		// Calculates date for one week ban
		LocalDateTime oneWeek = now.plusWeeks(1);
		// convert's to SQL date format
		Date banTime = Date.valueOf(oneWeek.toLocalDate());

    	try {
    		
			String query = "UPDATE " + users_db + " SET ban_status = 1, banTime = " + "'" + banTime + "'" + " WHERE id  = \""+id+"\"";
	        PreparedStatement p = con.prepareStatement(query);
	        int ban = p.executeUpdate(query);
	
	        if(ban == 1){
				System.out.println("User Banned Successfully");
				System.out.println("User Banned Until: " + banTime);
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

	//Returns penalty points for passed in user id
	public int getPenaltyPoints(int id) {
		
		// Initialise penalty variable
		int penalties = 0;

        try {
            
			String query = "SELECT penalties FROM " + users_db + " WHERE id = ?";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();

			while (rs.next()){
				// set penalties number from db
				penalties += rs.getInt("penalties");
				System.out.format("Penalties: " + penalties);
				
			}
              
        } catch (SQLException e) {
            
            System.out.println("Could not query the database " + e.getMessage());
            
		}
		
        return penalties;
	}

	// Adds penalty point to passed in user
	public void setPenaltyPoints(int id) {
		
		// Initialise penalty variable
		int penalties = 0;

        try {
            
			String query = "SELECT penalties FROM " + users_db + " WHERE id = ?";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();

			while (rs.next()){
				// set penalties number from db
				penalties += rs.getInt("penalties");
				System.out.format("Penalties: " + penalties);
				
			}

			p.setInt(penalties+1, id);
			p.close();
              
        } catch (SQLException e) {
            
            System.out.println("Could not query the database " + e.getMessage());
            
		}
		
	}

	// INSERTS new reservation into the reservations DB
	public void reserve(int id, String reg, String lot, int electric, int accessibility, long hours, long mins) throws SQLException{

		try {
			// Creating variables for created at and expiry attributes

			// Formatting
			DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime created_at_LocalDateTime = LocalDateTime.now();
			System.out.println("Reservation Created At: " + created_at_LocalDateTime.format(simpleDateFormat));
			LocalDateTime expiryDateTime = created_at_LocalDateTime;

			// Adding user desired duration to remain parked to expiry variable
			expiryDateTime = expiryDateTime.plus(Duration.ofHours(hours));  
			expiryDateTime = expiryDateTime.plus(Duration.ofMinutes(mins));
			System.out.println("Reservation expires: " + expiryDateTime.format(simpleDateFormat));

			//Converting ca & expiryDateTime to sql date format
			Date created_on = Date.valueOf(created_at_LocalDateTime.toLocalDate());
			Date expiry = Date.valueOf(expiryDateTime.toLocalDate());

			// INSERTING data to DB
			if(id > 0 && reg!=null && lot!=null && created_on!=null && expiry!=null){
				
				String query = "INSERT INTO " + reservations_db + "(userID, reg, lot, electric, accessibility, created_on, expiry) VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, reg);
				p.setString(3, lot);
				p.setInt(4, electric);
				p.setInt(5, accessibility);
				p.setDate(6, created_on);
				p.setDate(7, expiry);
				
	            int insert = p.executeUpdate();
	            if(insert == 1)
	            {
					System.out.println("Reservation made successfully");			
					System.out.println("Reservation From " + created_on + " Until " + expiry);

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

	// Admin function
	// Prints Reservation Details in DB
	// Stores their associated userID's in an array list of strings
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
			int i = 0;
			
			while(rs.next()){
				
				System.out.println("------------------------Reservation: "+i+"----------------------------");
				System.out.println("Reservations ID: " + rs.getInt("id"));
				System.out.println("User ID: " + rs.getInt("userID"));
				System.out.println("Registration Plate: " + rs.getString("reg"));
				System.out.println("LOT: " + rs.getString("lot"));
				System.out.println("Electric Car? [Y/N]: " + rs.getString("electric"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
				System.out.println("Reservation Data: " + rs.getDate("created_on"));
				System.out.println("Reserved until: " + rs.getDate("expiry"));
				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				// storing DB time variables locally 
				LocalDateTime reservationTimeDate = rs.getTimestamp("created_on").toLocalDateTime();
				LocalDateTime expiry = rs.getTimestamp("expiry").toLocalDateTime();
				
				// Creating day, hour, and minute variables by getting the difference between reservation time and expiry
				long mins = ChronoUnit.MINUTES.between(reservationTimeDate, expiry);
				long hours = ChronoUnit.HOURS.between(reservationTimeDate, expiry);
				Period durationPeriod = Period.between(reservationTimeDate.toLocalDate(), expiry.toLocalDate());
				int duration = durationPeriod.getDays();


				System.out.println("Reserved for:  " + duration + " Day(s)");
				System.out.println("Reserved for:  " + hours + " Hour(s)");
				System.out.println("Reserved for:  " + mins + " Min(s)");


				// Creating new reservation obj without adding it to the DB (false)
				Reservation collectedReservation = new Reservation(false, user, rs.getString("lot"), hours, mins);
				// Storing it in a reservations arraylist
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

	// INSERTS a new transaction into the transactions DB
	public void addTransaction(int userID, int reservationsID, String lot, double amount) throws Exception{

		try {
			// Creating variables for created at attribute
			LocalDate ca = LocalDate.now();
			//Converting ca & expiryDateTime to sql date format
			Date created_on = Date.valueOf(ca);

			// INSERTING data to DB
			if(userID > 0 && reservationsID>0 && amount>0 && created_on!=null ){
				
				String query = "INSERT INTO " + transactions_db + "(userID, reservationsID, lot, amount, created_on) VALUES (?, ?, ?, ?, ?)";

				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, userID);
				p.setInt(2, reservationsID);
				p.setString(3, lot);
				p.setDouble(4, amount);
				p.setDate(5, created_on);
				
	            int insert = p.executeUpdate();
	            if(insert == 1)
	            {
					System.out.println("Transaction logged successfully");			
					System.out.println("Transaction amount: " + amount);

	            }
	            else
	            {
	                System.out.println("Transaction Failed");
	            }
			}
		} catch (SQLException e){
			
	    	System.out.println("Error logging Transaction: " + e.getMessage());
			
		}
			
	}

	// Admin function
	// Returns entries in the transaction table
	public void fetchTransactionData() throws Exception{

		int i = 0;
		try {

			String query = "SELECT * FROM transactions WHERE userID = ";
	        PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);

			while(rs.next()){

				System.out.println("--------------------------Transaction: "+i+"------------------------------");

				System.out.println("Transaction ID: " + rs.getInt("id"));
				System.out.println("User ID: " + rs.getInt("userID"));
				System.out.println("Reservation ID: " + rs.getInt("reservationsID"));
				System.out.println("Lot: " + rs.getString("lot"));
				System.out.println("Amount: €" + rs.getInt("amount"));
				System.out.println("Created on: " + rs.getDate("created_on"));

				System.out.println("-----------------------------END-------------------------------");
				i++;
			}
			
			
		} catch (Exception e) {
	    	System.out.println("Error fetching transaction data: " + e.getMessage());
		}
			
	}

	public void fetchUserTransactionData(int id) throws Exception{

		int i = 0;
		try {

			String query = "select * from transactions WHERE userID = " + id;
	        PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);

			while(rs.next()){

				System.out.println("--------------------------Transaction: "+i+"------------------------------");
				System.out.println("Transaction ID: " + rs.getInt("id"));
				System.out.println("User ID: " + rs.getInt("userID"));
				System.out.println("Reservation ID: " + rs.getInt("reservationsID"));
				System.out.println("Lot: " + rs.getString("lot"));
				System.out.println("Amount: €" + rs.getInt("amount"));
				System.out.println("Created on: " + rs.getDate("created_on"));

				System.out.println("-----------------------------END-------------------------------");
				i++;
			}
			
			
		} catch (Exception e) {
	    	System.out.println("Error fetching transaction data: " + e.getMessage());
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