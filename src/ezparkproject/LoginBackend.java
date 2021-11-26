package ezparkproject;

import java.sql.SQLException;

public class LoginBackend {
	
	LoginBackend() {
		
	}
	
	public static void loginFunction(int id, String password) {
		
		
		Database User1 = new verifyUser(id, password);
	
	
	
	try {
		
		Database db = new Database();
		db.verifyUser(id, password);
		
	} catch (SQLException error) {

		System.out.println("Could not connect to the database " + error.getMessage());

	}

	
	
}

}

