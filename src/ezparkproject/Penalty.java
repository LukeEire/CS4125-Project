package ezparkproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Penalty {
	
	/* Code here */
	
	/*Count no-shows and add infraction to user in database 
	 * e.g NAME: Ashutosh, EMAIL:XYZ@XYZ.com, PENALTYCOUNT: 1
	 */

	/* If penaltyCount>3then LogoutUser with message 
	 * ("Too many no-shows this week, please come back in 1 week")
	 */

	/*Apply penalty if space not available within designated time 
	 * and apply monetary fee of 2 euro and store in penaltyAmount(int)
	 */
	
//	Reservation r = new Reservation();
//	int no_shows = r.no_shows;
	
	Connection conn = null;
	
	Users u = new Users();
	
	int no_shows = u.no_shows;
	int updateCount = 0;
	int Port_number = 3306;
	
	String Server = "sql4.freemysqlhosting.net";
	String Name = "sql4448569";
	String Username = "sql4448569";
	String Password = "rs5fNh4D5f";
	String db = "ParkingDB";
	String url = "jdbc:mysql://" + Server +  "/" + db;
	String driverName = "jdbc:mysql://sql4.freemysqlhosting.net";

	public void addInfraction(String username, int penaltyAmount1){
			
		String user_name = username;
		int penaltyAmount = penaltyAmount1;
		
	    try {
	    	
		  Class.forName(driverName);
		  conn= DriverManager.getConnection(url, Username, Password);
		  System.out.println("Successfully Connected to the database!");
		  
	    } catch (ClassNotFoundException e) {
	    		System.out.println("Could not find the database driver " + e.getMessage());
	    	} catch (SQLException e) {
	    		System.out.println("Could not connect to the database " + e.getMessage());
		}
		 
		try {

		PreparedStatement p = conn.prepareStatement("UPDATE ParkingDB SET PENALTY=? WHERE USERNAME = ?");
		p.setInt(1, penaltyAmount);
		p.setString(2, user_name);
		 
		// updateCount contains the number of updated rows
		updateCount = p.executeUpdate();
		
		System.out.println("Updated PENALTY Attribute successfully, Update Count = " + updateCount );
		 
		} catch (SQLException e) {
			System.out.println("Could not update data to the database " + e.getMessage());
		}
	}
	
	public int getInfractions(String username) {
		
		String user_name = username;
		int penalties = 0;
		
	    try {
	 
		  Class.forName(driverName);
		  conn = DriverManager.getConnection(url, Username, Password);
		  System.out.println("Successfully Connected to the database!");
		  
	    } catch (ClassNotFoundException e) {
	    	
	    		System.out.println("Could not find the database driver " + e.getMessage());
	    		
	    	} catch (SQLException e) {
	    		
	    		System.out.println("Could not connect to the database " + e.getMessage());
	    		
		}
	    
	    try {
	    	
		    String query = "SELECT PENALTY FROM ParkingDB WHERE USERNAME = ?";
		    //Creating the PreparedStatement object
		    PreparedStatement p = conn.prepareStatement(query);
		    
		    p.setString(1, user_name);
		    ResultSet rs = p.executeQuery();
		    
		    // iterate through the java resultset
		      while (rs.next())
		      {
		    	penalties += rs.getInt("PENALTY");
		        // print the results
		        System.out.format("Penalties = ... " + penalties);
		      }
		      
		      p.close();
		      
	    } catch (SQLException e) {
	    	
			System.out.println("Could query the database " + e.getMessage());
			
		}
		
		return penalties;
	}
	
	public void verifyInfractions(String username) {
		
		String user_name = username;
		int penaltyCount = getInfractions(user_name);
		
		if(penaltyCount >= 3) {
			//Logout functionality here
			//getTime() + 1 week
 			System.out.println("Too many no-shows this week, please come back in 1 week");
		} else {
			System.out.println("No Penalty points");
		}
	}
	
	public void penaliseNoShows(int no_shows) {
		for(int i = 0; i < no_shows; i++) {
			addInfraction(u.toString(), i);
		}
	}
}