package ezparkproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Penalty {

    Database db;
    Connection con = null;
	int updateCount = 0;
    int Port_number = 3306;
    
    public Penalty(){
    
        

        try{
            
            db = new Database();
            con = db.connect();

        } catch(SQLException e1){

            System.out.println("Could not connect to the database " + e1.getMessage());

        }

        // catch(ClassNotFoundException e){

        //     System.out.println("Could not find the database driver " + e.getMessage());

        // } catch(SQLException e1){

        //     System.out.println("Could not connect to the database " + e1.getMessage());

        // }

    }

	public void penaliseNoShows(int id) {
        
        //Logout functionality here
        //getTime() + 1 week
		try {

            db.banUser(id);
            System.out.println("Too many no-shows this week, please come back in 1 week");
        
        } catch (SQLException e) {

            System.out.println("SQL exception: " + e.getMessage());
        
        }
    }

	public int getInfractions(int id) {
        
        int user_id = id;
        int penalties = 0;

        try {
            
            String query = "SELECT penalties FROM useers WHERE id = ?";
            PreparedStatement p = con.prepareStatement(query);
            
            p.setInt(1, user_id);
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
            
            penaliseNoShows(user_id);
            
        }
        
        return penalties;
    }

	public void addInfraction(int id){
        
        int user_id = id;
        int currentPenalties = getInfractions(user_id);
        
        try {

            PreparedStatement p = con.prepareStatement("UPDATE ParkingDB SET PENALTY=? WHERE user_id = ?");
            p.setInt(1, currentPenalties+1);
            p.setInt(2, user_id);
             
            // updateCount contains the number of updated rows
            updateCount = p.executeUpdate();
            
            System.out.println("Updated PENALTY Attribute successfully, Update Count = " + updateCount );
         
        } catch (SQLException e) {
            
            System.out.println("Could not update data to the database " + e.getMessage());
            
        }
    }
}
