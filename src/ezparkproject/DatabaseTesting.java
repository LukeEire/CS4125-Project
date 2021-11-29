// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
package ezparkproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  ayoub
 * @version 28/11/21
 */
public class DatabaseTesting
{
    /**
     * Default constructor for test class DatabaseTest
     */
    @Test
     public DatabaseTesting(){
        package ezparkproject;

public class Testing_database {
    public static void main(String[] args) throws Exception
    {
        //Ayoub testing - the following has been tested and all works - 24/11/2021
        
		// Connect to the db, RUN ALL TO SEE
		// 	NOTE DUPLICATE ENTRIES ARE NOT ALLOWS
		System.out.println("Testing");
		Database db = new Database();
		
		// HOW TO GET A CON OBJECT (ALTHOUGH YOU DONT REALLY NEED TO)
		db.connect();

        // Clear table contents
		db.clearTable("users");
		db.clearTable("reservations");
		db.clearTable("transactions");
        
        // Drop DB tables
		db.dropTable("users");
		db.dropTable("reservations");
		db.dropTable("transactions");

        // CREATE DB tables
		db.createUsersTable();
		db.createReservationsTable();
		db.createTransactionsTable();

		// HOW TO REGISTER A NEW USER
		db.newUser(18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");
		db.newUser(18266402, "Ayoub2", "Jdair", "Password123", "Staff", 0, 0, "2001-12-15", "123HG654");
		db.newUser(18266403, "Ayoub3", "Jdair", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		db.newUser(18266404, "Ayoub4", "Jdair", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");

		// HOW TO DELETE/BAN/UNBAN A USER USING USER ID'S

		db.deleteUser(18266403);
		db.deleteUser(18266404);

		db.banUser(18266401);
		db.banUser(18266402);

		db.unBanUser(18266401);
		
		
		// HOW TO PRINT USER'S DB ITEMS - PRINT STATEMENT + ARRAYLIST
        db.fetchData();
		
		// HOW TO VERIFY A USER (LOGIN)
		String password = "Password123";
		boolean b = db.verifyUser(18266404, password);
		System.out.println(b);
		
		//How to reserve a space using DB class, can also be done using Registration class
		db.reserve(18266401, "CALIFORNIA", "Lot A", 1, 0, 1, 1);
		db.reserve(18266401, "NEWYORK", "Lot B", 1, 0, 1, 1);
		db.reserve(18266401, "CHICAGO", "Lot A", 1, 0, 1, 1);
		db.reserve(18266401, "WASHINGTON", "Lot A", 1, 0, 1, 1);

		//How to get reservation details
		db.fetchReservationData();
		Users ayoub = new Users(true, 18266406, "Jack", "H", "123456789", null, "Student", 1, 0, "1999-12-15", "PENN");
		db.reserve(ayoub.id, ayoub.getDefultPlate(), "LOT A", 1, 0, 2, 15);
		db.fetchUserReservation(ayoub);

		//Transaction
		db.addTransaction(18266401, 1, "Lot A", 2.40);
		db.addTransaction(18266401, 2, "Lot B", 2.45);
		
		db.fetchTransactionData();
		db.fetchUserTransactionData(ayoub.getID());

    }
}
        
    }
}