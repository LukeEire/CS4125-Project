package PenaltyPackage;

import java.sql.SQLException;

import ezparkproject.Database;

public class PenaltyBackend {
    Database db;
    int penalties;

    /**
    * Constructor that takes in no params
    * Initialises Database object
    * Initialises penalties variable
    */
    public PenaltyBackend(){ 

        penalties = 0;

        try{
            
            db = new Database();

        } catch(SQLException e1){

            System.out.println("PenaltyBackend: Could not connect to the database " + e1.getMessage());

        }

    }

    /**
    * Preconditions: int id is a valid user stored in the DB
    * Postconditions: The user's penalty attribute is incremented by 1
    */

    // Adds one penalty point to passed in user
    // Invokes check for user penalties and bans user if penalties exceed 3
	public void PenaltyBackendAddInfraction(int id){
        db.setPenaltyPoints(id);  
        PenaltyBackendGetInfractions(id);
    }

    /**
    * Preconditions: int id is a valid user stored in the DB
    * Postconditions: returns an integer value of the users penalties to date according to the DB
    */

    // Returns penalty count for user
	public int PenaltyBackendGetInfractions(int id) {
        penalties = db.getPenaltyPoints(id);
        PenaltyBackendPenaliseUser(id, penalties);
        return penalties;
    }

    /**
    * Preconditions: int id is a valid user stored in the DB
    * Postconditions: Will set user ban status to true if penalties exceed 3
    */
    
    // IF user surpasses 3 penalty points, we ban the user for one week
	public void PenaltyBackendPenaliseUser(int userId, int userPenalties) {
        
        if(userPenalties >= 3) {
			try {
				db.banUser(userId);
				System.out.println("User " + userId + " Penalised!");

			} catch (SQLException e) {
                System.out.println("Error penalising User " + userId + " .");
				System.out.println("SQL exception: " + e.getMessage());
				e.printStackTrace();
			}
        }
    }   
}
