package ezparkproject;

import java.sql.SQLException;

import javax.swing.JFrame;

/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.02
 * */




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
        
		//AdminFrame frame = new AdminFrame();
        //new AdminFrame ();

    	Database db = new Database();
    	
    	db.dropTable("reservations");
    	db.dropTable("users");
    	db.dropTable("transactions");

    	db.createReservationsTable();
    	db.createTransactionsTable();
    	db.createUsersTable();
       
    }
}