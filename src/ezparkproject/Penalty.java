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

    Database db = new Database();
//    Connection conn = db.connect();

    try {
        
        Connection conn = db.connect();
        
    } catch (ClassNotFoundException e) {
        
        System.out.println("Could not find the database driver " + e.getMessage());
        
    } catch (SQLException e1) {
        
        System.out.println("Could not connect to the database " + e1.getMessage());

    }
    
    
    int updateCount = 0;
    int Port_number = 3306;

    
    public void penaliseNoShows(String username) {
        
        //Logout functionality here
        //getTime() + 1 week
        db.banUser(username);
        System.out.println("Too many no-shows this week, please come back in 1 week");
        
    }

    public int getInfractions(String username) {
        
        String user_name = username;
        int penalties = 0;

        try {
            
            String query = "SELECT PENALTY FROM ParkingDB WHERE USERNAME = ?";
            PreparedStatement p = conn.prepareStatement(query);
            
            p.setString(1, user_name);
            ResultSet rs = p.executeQuery();
            
              while (rs.next()){
                  
                penalties += rs.getInt("PENALTY");
                System.out.format("Penalties: " + penalties);
                
              }
            
              p.close();
              
        } catch (SQLException e) {
            
            System.out.println("Could not query the database " + e.getMessage());
            
        }
        
        if(penalties >= 3) {
            
            penaliseNoShows(user_name);
            
        }
        
        return penalties;
    }
    
    public void addInfraction(String username){
        
        String user_name = username;
        int currentPenalties = getInfractions(user_name);
        
        try {

            PreparedStatement p = conn.prepareStatement("UPDATE ParkingDB SET PENALTY=? WHERE USERNAME = ?");
            p.setInt(1, currentPenalties+1);
            p.setString(2, user_name);
             
            // updateCount contains the number of updated rows
            updateCount = p.executeUpdate();
            
            System.out.println("Updated PENALTY Attribute successfully, Update Count = " + updateCount );
         
        } catch (SQLException e) {
            
            System.out.println("Could not update data to the database " + e.getMessage());
            
        }
    }
}