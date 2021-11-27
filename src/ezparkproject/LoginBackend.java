package ezparkproject;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginBackend {
	
	LoginBackend() {
		
	}
	
	public static void loginFunction(int id, String password) {
		
	
	
	
	try {
		
		Database db = new Database();
		
		
		if (db.verifyUser(id, password)) {
			
			Dashboard frame = new Dashboard();
            frame.setVisible(true);
            System.out.print("You have successfully logged in");
		
		}else {
			System.out.print("Incorrect username or password");
		
		}
		
	} catch (SQLException error) {

		System.out.println("Could not connect to the database " + error.getMessage());

	}

	
	
}

}

