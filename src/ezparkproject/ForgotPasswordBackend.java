package ezparkproject;

import java.sql.SQLException;

public class ForgotPasswordBackend {
    
    // Pre-Condition - Passed value must be of type string
    // Post-Condition - Verifies that email passed into this function is present in the Users Database
	// Returns true if email are exists, false otherwise
    public static boolean verifyEmail(String email) throws SQLException{
        Database db = new Database();
        boolean result = db.verifyUserEmail(email);
        return result;
    }

}
