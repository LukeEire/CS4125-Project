package ezparkproject;

import java.sql.SQLException;

/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.02
 * */


public class Main {
    public static void main(String[] args) throws Exception
    {
        //creating object of class Users, Login etc
        
    	//new RegFrame();
      	
    	//Ayoub testing - the following has been tested and all works - 24/11/2021
		Database db = new Database();
		
		// HOW TO GET A CON OBJECT (ALTHOUGH YOU DONT REALLY NEED TO)
		//db.getConnection();
		//db.connect();
		
		// HOW TO REGISTER A NEW USER
		//db.newUser(18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");
		//db.newUser(18266403, "Ayoub2", "Jdair", "Password123", "Staff", 0, 0, "2001-12-15", "123HG654");
		//db.newUser(18266404, "Ayoub3", "Jdair", "Password123", "Guest", 1, 1, "2010-12-15", "12HFD234");
		//db.newUser(18266405, "Ayoub4", "Jdair", "Password123", "Student", 0, 1, "1999-12-15", "99CE1234");
		
		// HOW TO PRINT USER'S DB ITEMS - PRINT STATEMENT + ARRAYLIST
		//db.fetchData();
		//db.test();
		
		// HOW TO DELETE/BAN/UNBAN A USER USING USER ID'S
		//db.deleteUser(18266401);
		//db.deleteUser(18266403);
		//db.deleteUser(18266404);
		//db.deleteUser(18266405);
		//db.deleteUser(18266409);
		
		//db.banUser(18266403);
		//db.banUser(18266404);
		
		//db.unBanUser(18266403);
		//db.unBanUser(18266404);
	
		// HOW TO VERIFY A USER (LOGIN)
		//String password = "Password123";
		//boolean b = db.verifyUser(18266404, password);
		//System.out.println(b);
		
		
       
    }
}