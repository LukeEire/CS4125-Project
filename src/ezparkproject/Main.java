package ezparkproject;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

import javax.swing.JFrame;

public class Main {
	
	Lot LotA = new Lot ("LotA", 300, 10, 3);
	Lot LotB = new Lot ("LotB", 350, 15, 0);
	Lot LotC = new Lot ("LotC", 300, 15, 5);
	Lot LotD = new Lot ("LotD", 400, 20, 10);
	
	
    public static void main(String[] args) throws Exception
    {

//    	LoginFunction frame = new LoginFunction();
//        frame.setTitle("Login Form");
//        frame.setVisible(true);
//        frame.setBounds(500, 200, 1100, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
        
        System.out.println("Testing Database");
		Database db = new Database();
		
		// HOW TO GET A CON OBJECT (ALTHOUGH YOU DONT REALLY NEED TO)
		db.connect();

        db.dissembleDatabase();
        
        db.rebuildDatabase();


		// HOW TO REGISTER A NEW USER
		db.newUser(18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");
		db.newUser(18266402, "Luke", "M", "Password123", "Staff", 0, 0, "2001-12-15", "123HG654");
		db.newUser(18266403, "Ash", "K", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		db.newUser(18266404, "Conall", "Mc", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");
		db.newUser(18266405, "Ash", "K", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		db.newUser(18266406, "Conall", "Mc", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");

		// HOW TO DELETE/BAN/UNBAN A USER USING USER ID'S

		db.deleteUser(18266403);
		db.deleteUser(18266404);

		db.banUser(18266401);
		db.banUser(18266402);

		db.unBanUser(18266401);

		// HOW TO VERIFY A USER (LOGIN)
		String password = "Password123";
		boolean b = db.verifyUser(18266401, password);
		System.out.println("User verification result: " + b);
		
		// HOW TO PRINT USER'S DB ITEMS - PRINT STATEMENT + ARRAYLIST
        db.fetchData();
		
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
		
		//Using method arraylist
		ArrayList<Users> users = db.fetchData();
		ArrayList<String> lots = new ArrayList<String>();
			lots.add("Lot A");
			lots.add("Lot B");
			lots.add("Lot C");
			lots.add("Lot D");
		for(int i = 0; i<users.size(); i++){
			int random_int = (int)Math.floor(Math.random()*(3-0+1)+0);
			Reservation reservation = new Reservation(true, users.get(i), lots.get(random_int), random_int, 30);
			db.addTransaction(users.get(i).id, i, lots.get(i), random_int+.35);
		}

		//Transaction
		db.addTransaction(18266401, 1, "Lot A", 2.40);
		db.addTransaction(18266401, 2, "Lot B", 2.45);
		
		db.fetchTransactionData();
		db.fetchUserTransactionData(ayoub.getID());
       
    }
}