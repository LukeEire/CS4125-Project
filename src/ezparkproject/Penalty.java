package ezparkproject;

public class Penalty {

    PenaltyBackend pb;

    /**
    * Constructor that takes in no params
    */
    
    public Penalty(){ 
        pb = new PenaltyBackend();
    }

    /**
    * Preconditions: int id is a valid user stored in the DB
    * Postconditions: The user's penalty attribute is incremented by 1
    */

    // Adds one penalty point to passed in user
    // Invokes check for user penalties and bans user if penalties exceed 3
	public void addInfraction(int id){
        pb.PenaltyBackendAddInfraction(id);  
    }


    /**
    * Preconditions: int id is a valid user stored in the DB
    * Postconditions: returns an integer value of the users penalties to date according to the DB
    */

    // Returns penalty count for user
	public int getInfractions(int id) {
        return pb.PenaltyBackendGetInfractions(id);
    }

}
