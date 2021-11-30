package ezparkproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.random.RandomGenerator;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  testingUser
 * @version 28/11/21
 */
public class DatabaseTesting
{
	public static void main(String[] args) throws Exception{
		System.out.println("Testing Database");
		Database db = new Database();
		Users testingUser = new Users(true, 22222222, "Jack", "H", "123456789", null, "Student", 1, 0, "1999-12-15", "PENN");
		
		// HOW TO GET A CON OBJECT (ALTHOUGH YOU DONT REALLY NEED TO)
		System.out.println();
		System.out.println();  
		System.out.println("Test 1");
		db.connect();
		
		System.out.println();  
		System.out.println("Test 2");
		db.dissembleDatabase();	
		System.out.println();  

		System.out.println("Test 3");
		System.out.println();
        db.rebuildDatabase();
		System.out.println();  


		// HOW TO REGISTER A NEW USER
		System.out.println("Test 4");
		System.out.println();
		db.newUser(18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");
		db.newUser(18266402, "Luke", "M", "Password123", "Staff", 0, 0, "2001-12-15", "123HG654");
		db.newUser(18266403, "Ash", "K", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		db.newUser(18266404, "Conall", "Mc", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");
		db.newUser(18266405, "Ash", "K", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		db.newUser(18266406, "Conall", "Mc", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");
		System.out.println();  

		// HOW TO DELETE/BAN/UNBAN A USER USING USER ID'S
		System.out.println("Test 5");
		System.out.println();
		db.deleteUser(18266403);
		db.deleteUser(18266404);
		System.out.println();  

		System.out.println("Test 6");
		System.out.println();
		db.banUser(18266401);
		db.banUser(18266402);
		System.out.println();  

		System.out.println("Test 7");
		System.out.println();
		db.unBanUser(18266401);
		System.out.println();  

		// HOW TO VERIFY A USER (LOGIN)
		System.out.println("Test 8");
		System.out.println();
		String password = "Password123";
		boolean b = db.verifyUser(18266401, password);
		System.out.println("User verification result: " + b);
		System.out.println();  
		
		// HOW TO PRINT USER'S DB ITEMS - PRINT STATEMENT + ARRAYLIST
		System.out.println("Test 9");
		System.out.println();
		db.fetchData();
		System.out.println();  
		
		
		//How to reserve a space using DB class, can also be done using Registration class
		System.out.println("Test 10");
		System.out.println();
		db.reserve(18266401, "CALIFORNIA", "Lot A", 1, 0, 1);
		db.reserve(18266401, "NEWYORK", "Lot B", 1, 0, 2);
		db.reserve(18266401, "CHICAGO", "Lot A", 1, 0, 2);
		db.reserve(18266401, "WASHINGTON", "Lot A", 1, 0, 1);
		System.out.println();  

		//How to get reservation details
		System.out.println("Test 11");
		System.out.println();
		db.fetchReservationData();
		db.reserve(testingUser.id, testingUser.getDefultPlate(), "LOT A", 1, 0, 2);
		db.fetchUserReservation(testingUser);
		
		//Transaction
		System.out.println("Test 12");
		System.out.println();
		db.addTransaction(18266401, 1, "Lot A", 2.40);
		db.addTransaction(18266401, 2, "Lot B", 2.45);
		System.out.println();  

		System.out.println("Test 13");
		System.out.println();
		db.fetchTransactionData();
		db.fetchUserTransactionData(testingUser.getID());
		
		//Using method arraylist
		System.out.println();  
		System.out.println("Test 14");
		System.out.println();
		ArrayList<Users> users = db.fetchData();
		ArrayList<String> lots = new ArrayList<String>();
			lots.add("Lot A");
			lots.add("Lot B");
			lots.add("Lot C");
			lots.add("Lot D");
			
//		for(int i = 0; i<users.size(); i++){
//			int random_int = (int)Math.floor(Math.random()*(3-0+1)+0);
//			// Reservation reservation = new Reservation(true, users.get(i), lots.get(random_int), random_int, 30);
//			Reservation reservation = new Reservation(true, users.get(i), lots.get(random_int), users.get(i).electric, users.get(i).getDefultPlate(), 2);
//			db.addTransaction(users.get(i).id, i, lots.get(i), random_int+.35);
//		}

		System.out.println();  
		System.out.println("Test 15");
		System.out.println();
		LocalDateTime bookingTime = LocalDateTime.of(2021, Month.DECEMBER, 10, 13, 30, 40);
		db.preBook(testingUser.id, testingUser.getDefultPlate(), lots.get(0), testingUser.electric, testingUser.accessibility, bookingTime, 2);
		System.out.println();
		
		// HOW TO SET PENALTY POINTS AND GET PENALTY POINTS FOR USERS
		System.out.println("Test 16");
		db.setPenaltyPoints(testingUser.id);
		int p = db.getPenaltyPoints(testingUser.id);
		System.out.println("Returned penalty points:  "+ p); 
		System.out.println(); 
		
		// HOW TO CHANGE USER PASSWORDS FOR USERS
		System.out.println("Test 17");
		String newPassword = "MD5passwordsSuck100";
		db.changePassword(testingUser.id, newPassword);
		System.out.println(); 
		
		System.out.println();  
		System.out.println("Testing Complete.");
		System.out.println();  
	}
}	