package ezparkproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Penalty {

    Database db;
    int penalties;

    
    public Penalty(){ 

        penalties = 0;

        try{
            
            db = new Database();

        } catch(SQLException e1){

            System.out.println("Could not connect to the database " + e1.getMessage());

        }

    }

    // Returns penalty count for user
	public int getInfractions(int id) {

        penalties = db.getPenaltyPoints(id);

        if(penalties >= 3) {
            penaliseNoShows(id); 
        }
        
        return penalties;
    }

    // Adds one penalty point to passed in user
	public void addInfraction(int id){
        
        db.setPenaltyPoints(id);  

    }

    // IF user surpasses 3 penalty points, we ban the user for one week
	public void penaliseNoShows(int id) {
        
        int penalties = db.getPenaltyPoints(id);

        if(penalties >= 3) {
            
			try {
				db.banUser(id);
				System.out.println("Too many no-shows this week, please come back in 1 week");

			} catch (SQLException e) {
				System.out.println("SQL exception: " + e.getMessage());
				e.printStackTrace();
			}
        }
    }
}
