package ezparkproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ayoubjdair
 *For easily accessing the DB and reducing duplicate code
 *maybe delete the query from ResultSet rs = p.executeQuery(query);
 *lmk if anyone tests this class
 */
public class Database {
	
	Connection conn;
	
	int Port_number;
	
	String server;
	String name;
	String username;
	String password;
	String db;
	String url;
	String driverName;
	
	public Database() {
		
		Connection conn = null;
		
		int Port_number = 3306;
		
		String server = "sql4.freemysqlhosting.net";
		String name = "sql4448569";
		String username = "sql4448569";
		String password = "rs5fNh4D5f";
		String db = "ParkingDB";
		String url = "jdbc:mysql://" + server +  "/" + db;
		String driverName = "jdbc:mysql://sql4.freemysqlhosting.net";
	}
	
	public Connection connect() throws SQLException , ClassNotFoundException {
		//Creates connection
		 try {
		    	
			  Class.forName(driverName);
			  conn = DriverManager.getConnection(url, username, password);
			  System.out.println("Successfully Connected to the database!");
			  return conn;
			  
		    } catch (ClassNotFoundException e) {
		    	
		    	System.out.println("Could not find the database driver " + e.getMessage());
		    	return null;
		    		
		    } catch (SQLException e) {
		    	
		    	System.out.println("Could not connect to the database " + e.getMessage());
		    	return null;
			}
	}
	
	public void fetchData() throws Exception{
		try {
			//Getting all DB data
			String query = "select * from ParkingDB";
	        PreparedStatement p = conn.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			List<String> users = new ArrayList<String>();

			while(rs.next()){
//				USERNAME
//				UNISTATUS
//				USERPASSWORD
//				CONFIRMPASSWORD
//				EMAIL
//				ELECTRIC
//				ACCESSIBILITY
//				BANNED
//				PENALTY

				int i = 0;
				System.out.println("------------------------User: "+i+"----------------------------");
				System.out.println("Username: " + rs.getString("USERNAME"));
				System.out.println("Status: " + rs.getString("UNISTATUS"));
				System.out.println("Password: " + rs.getString("USERPASSWORD"));
				System.out.println("Email: " + rs.getString("EMAIL"));
				System.out.println("Electric Car? [Y/N]: " + rs.getString("ELECTRIC"));
				System.out.println("Assistance Required? [Y/N]: " + rs.getString("ACCESSIBILITY"));
				System.out.println("Banned Status: " + rs.getInt("BANNED"));
				System.out.println("Penalty Points: " + rs.getInt("PENALTY"));
				System.out.println("-----------------------------END-------------------------------");
				i++;
				
				users.add(rs.getString(1));
			}
			
			System.out.println("Users Arraylist");
			System.out.println(users);
			
		} catch (Exception e) {
			
	    	System.out.println("Error fetching data: " + e.getMessage());
	    	
		}
			
	}
	
	public void newUser(String username, String status, String password, String email, int ev, int accessibility) throws SQLException {
		
		try {
			
			if(username!=null && status!=null && password!=null && email!=null){
        	
	            String query = "INSERT INTO ParkingDB(USERNAME, UNISTATUS, USERPASSWORD, CONFIRMPASSWORD, EMAIL, ELECTRIC, ACCESSIBILITY, BANNED, PENALTY) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
		        PreparedStatement p = conn.prepareStatement(query);
		        p.setString(1, username);
		        p.setString(2, status);
		        p.setString(3, password);
		        p.setString(4, password); 
		        p.setString(5, email);
		        
		        if(ev >= 1) {
		        	p.setInt(6, 1);
		        } else {
		        	p.setInt(6, 0);
		        }
		        
		        if(accessibility >= 1) {
		        	p.setInt(7, 1);
		        } else {
		        	p.setInt(7, 0);
		        }
		        
		        p.setInt(8, 0);
		        p.setInt(9, 0);
		        
	            int insert = p.executeUpdate(query);
	
	            if(insert == 1)
	            {
	                System.out.println("New user added successful");
	            }
	            else
	            {
	                System.out.println("Update Failed");
	            }
			}
		} catch (SQLException e){
			
	    	System.out.println("Error registering new user: " + e.getMessage());
			
		}
    }
	
    public void deleteUser(String username) throws Exception {
    	
    	try {
    		
    		String query = "DELETE FROM ParkingDB WHERE USERNAME = \""+username+"\"";
	        PreparedStatement p = conn.prepareStatement(query);
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
    
    public void banUser(String username) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE ParkingDB SET BANNED = 1 WHERE USERNAME = \""+username+"\"";
	        PreparedStatement p = conn.prepareStatement(query);
	        int ban = p.executeUpdate(query);
	
	        if(ban == 1){
	        	System.out.println("User removed");
	        }
	        else{
	            System.out.println("deletion Failed");
	        }
	        
    	} catch (SQLException e){

    		System.out.println("Error banning user: " + e.getMessage());

    	}
    	
    }
    
	public void unBanUser(String username) throws SQLException{
    	
    	try {
    		
    		String query = "UPDATE ParkingDB SET BANNED = 0 WHERE USERNAME = \""+username+"\"";
            PreparedStatement p = conn.prepareStatement(query);
            int unBan = p.executeUpdate(query);

            if(unBan == 1){
            	System.out.println("User removed");
            }
            else{
                System.out.println("deletion Failed");
            }
	        
    	} catch (SQLException e){

    		System.out.println("Error unbanning user: " + e.getMessage());

    	}
    }
	
	public void verifyUser(String username, String password) throws SQLException {
		
		String checkUser = username;
		String checkPass = password;
		
		try {
			
			String query = "SELECT * FROM ParkingDB WHERE USERNAME = "+checkUser+" AND USERPASSWORD = "+checkPass;
			PreparedStatement p = conn.prepareStatement(query);
			ResultSet rs = p.executeQuery(query);
			
			while (rs.next()) {
				String foundUser = rs.getString("USERNAME");
				String foundPass = rs.getString("USERPASSWORD");
				System.out.println("Found User: "+foundUser);
				System.out.println("User Password: "+foundPass);
			}
			
		} catch(SQLException e) {
			
			System.out.println("User OR password may be inccorect");
			System.out.println("User: "+ checkUser);
			System.out.println("Password: " + checkPass);
			System.out.println("Error locating data entered: " + e.getMessage());
			
		}
	}
	
	//Returns 0 for student, 1 for staff, 2 for guest
	public int getUserStatus(String username) throws SQLException{
		
		try {
			
			String query = "SELECT UNISTATUS FROM ParkingDB WHERE USERNAME = ?";
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, username);
			ResultSet rs = p.executeQuery();
			
			if(rs.getString(1) == "Student") {
				
				return 0;
				
			} else if (rs.getString(1) == "Staff") {
				
				return 1;
				
			} else if (rs.getString(1) == "Guest") {
				
				return 2;
				
			} else {
				
				return 3;
				System.out.println("Query returned: " + rs.getString(1));
				
			}
		} catch (SQLException e) {
			
			System.out.println("SQL error: " + e.getMessage());
			
		}
	}
}