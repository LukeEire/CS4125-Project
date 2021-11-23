package ezparkproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ayoubjdair
 *For easily accessing the DB and reducing duplicate code
 *maybe delete the query from ResultSet rs = p.executeQuery(query);
 *lmk if anyone tests this class
 */
public class Database {
	
	protected Connection con;
	protected String server;
	protected String name;
	protected String username;
	protected String password;
	protected String db;
	protected String reservations_db;
	protected String url;
	protected String driverName;
	protected int Port_number;

	public Database() throws SQLException{
		//creates a DB object and connects to the DB
		Port_number = 3306;
		server = "sql4.freesqldatabase.com";
		// name = "sql4450358";
		username = "sql4450358";
		password = "dcCxqbDW1K";
		db = "users";
		reservations_db = "reservations";
		// url = "jdbc:mysql://" + server +  "/" + db;
		driverName = "jdbc:mysql://sql4.freesqldatabase.com";

		try {
			
			con = DriverManager.getConnection(driverName, username, password);
			System.out.println("Successfully Connected to the database!");
				  
		} catch (SQLException e) {
			  
			System.out.println("Could not connect to the database " + e.getMessage());

		}

	}
	
	public Database getConnection() throws SQLException {
		try {
			con = DriverManager.getConnection(driverName, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Successfully Connected to the database!");
		return null;
	}
	
	public Connection connect(){
		//returns connection
		System.out.println("Sever: " + server);
		System.out.println("Name: " + name);
		System.out.println("Password: " + password);
		System.out.println("DB: " + db);
		System.out.println("URL: " + driverName);
		return con;
	}

	
	public void fetchData() throws Exception{
		try {
			//Getting all DB data
			String query = "select * from " + db;
	        PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			List<String> users = new ArrayList<String>();

			while(rs.next()){

				int i = 0;
				System.out.println("------------------------User: "+i+"----------------------------");
				System.out.println("User ID: " + rs.getInt("id"));
				System.out.println("Firs name: " + rs.getString("firstName"));
				System.out.println("Last name: " + rs.getString("lastName"));
				System.out.println("Status: " + rs.getInt("status"));
				System.out.println("Password: " + rs.getString("password"));
				System.out.println("Email: " + rs.getString("email_address"));
				System.out.println("Electric Car? [Y/N]: " + rs.getString("electric"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("accessibility"));
				System.out.println("Banned Status: " + rs.getInt("ban_status"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Created on: " + rs.getDate("created_on"));
				System.out.println("D.O.B: " + rs.getDate("dob"));
				System.out.println("Penalty Points: " + rs.getInt("penalties"));
				System.out.println("Defualt Registration Plate: " + rs.getString("reg"));

				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				users.add(rs.getString(1));
			}
			
			System.out.println("Users Arraylist: ");
			System.out.println(users);
			
		} catch (Exception e) {
			
	    	System.out.println("Error fetching data: " + e.getMessage());
	    	
		}
			
	}
	
	public void newUser(int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String sdob, String reg) throws SQLException {
		
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
				// reg

				String query = "INSERT INTO " + db + "(id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob, reg ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
				
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
				p.setString(13, reg);
		        
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
	
    public void deleteUser(int id) throws Exception {
    	
    	try {
    		
    		String query = "DELETE FROM " + db + " WHERE id = \""+id+"\"";
	        PreparedStatement p = con.prepareStatement(query);
	        int delete = p.executeUpdate(query);
	
	        if(delete == 1){
	        	System.out.println("User removed");
	        }
	        else{
	            System.out.println("deletion Failed");
	        }
	        
    	} catch (Exception e){

    		System.out.println("Error deleting user: " + e.getMessage());

    	}
        
    }
    
    public void banUser(int id) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE " + db + " SET ban_status = 1 WHERE id = \""+id+"\"";
	        PreparedStatement p = con.prepareStatement(query);
	        int ban = p.executeUpdate(query);
	
	        if(ban == 1){
	        	System.out.println("User Banned");
	        }
	        else{
	            System.out.println("Ban Failed");
	        }
	        
    	} catch (SQLException e){

    		System.out.println("Error banning user: " + e.getMessage());

    	}
    	
    }
    
	public void unBanUser(int id) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE " + db + " SET ban_status = 0 WHERE id = \""+id+"\"";
            PreparedStatement p = con.prepareStatement(query);
            int unBan = p.executeUpdate(query);

            if(unBan == 1){
            	System.out.println("User unbanned");
            }
            else{
                System.out.println("unban Failed");
            }
	        
    	} catch (SQLException e){

    		System.out.println("Error unbanning user: " + e.getMessage());

    	}
    }
	
	public void verifyUser(int id, String password) throws SQLException {
		
		int checkUser = id;
		String checkPass = password;
		
		try {
			
			String query = "SELECT * FROM " + db + " WHERE id = "+checkUser+" AND password = "+checkPass;
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			
			while (rs.next()) {
				int foundUser = rs.getInt("id");
				String foundPass = rs.getString("password");
				System.out.println("Found User: "+foundUser);
				System.out.println("User Password: "+foundPass);
			}
			
		} catch(SQLException e) {
									
			System.out.println("Error locating data entered: " + e.getMessage());
			System.out.println("UserID OR password may be incorrect");
			System.out.println("User: "+ checkUser);
			System.out.println("Password: " + checkPass);
			
		}
	}
	
	//Returns 0 for student, 1 for staff, 2 for guest
	public int getUserStatus(int id) throws SQLException{
		
		try {
			
			String query = "SELECT status FROM " + db + " WHERE id = ?";
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

				String query = "INSERT INTO " + db + "(id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob ) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
				
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
	


//Ayoub
	//Preliminary List of booking requirements (for reservations table): 
	//lmk if you wanna talk about adding or removing any
	// - USER ID
	// - Reservation ID
	// - Lot?
	// - Electric?
	// - Accessability?
	// - Expiry (Date entered for user to check out of parking space)
	public void reserve(int id, String reg, String lot, int electric, int accessibility, String sexpiry) throws SQLException {

		LocalDate ca = LocalDate.now();
		Date created_at = Date.valueOf(ca);

		java.util.Date expiry = new Date(2000);
		try {
			expiry = new SimpleDateFormat("dd/MM/yyyy").parse(sexpiry);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 

		try {
			
			if(id > 0 && lot!=null){
				
				String query = "INSERT INTO " + reservations_db + "(id, reg, lot, electric, accessability, created_on, expiry) VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, reg);
				p.setString(3, lot);
				p.setInt(4, electric);
				p.setInt(5, accessibility);
				p.setDate(6, created_at);
				p.setDate(7, (Date) expiry);

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
	


	public void fetchReservationData() throws Exception{
		try {
			//Getting all DB data
			String query = "select * from " + reservations_db;
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			ArrayList<String> reservations = new ArrayList<String>();

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
				
				reservations.add(rs.getString(1));
			}
			
			System.out.println("Reservations Arraylist: ");
			System.out.println(reservations);
			
		} catch (Exception e) {
			
			System.out.println("Error fetching data: " + e.getMessage());
			
		}
			
	}

	
}