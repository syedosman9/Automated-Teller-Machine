package amnos.management.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetPin extends DatabaseConnection{
	
	public void changePin(String userId, String oldPin, String newPin) {
		try {
			PreparedStatement updateQuery = connection.prepareStatement("update user_login_details set pin=? where pin=?");
			updateQuery.setString(1, newPin);
			updateQuery.setString(2, oldPin);
			updateQuery.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
