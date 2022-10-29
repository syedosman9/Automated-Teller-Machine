package amnos.management.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDetails extends DatabaseConnection{
	
	public void insertLoginDetails(String customerId, String customerCardNumber, String customerPinNumber) {
		try {
			PreparedStatement insertQuery = connection.prepareStatement("insert into user_login_details values(?,?,?)");
			insertQuery.setString(1, customerId);
			insertQuery.setString(2, customerCardNumber);
			insertQuery.setString(3, customerPinNumber);
			insertQuery.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUserId(String cardNumber, String pin) {
		try {
			PreparedStatement selectQuery = connection
					.prepareStatement("select user_id from user_login_details where cardnumber= ? and pin=?");
			selectQuery.setString(1, cardNumber);
			selectQuery.setString(2, pin);
			ResultSet queryResult = selectQuery.executeQuery();
			queryResult.next();
			String userId = queryResult.getString("user_id");
			return userId;

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public boolean checkLoginDetails(String cardNumber, String pin) {
		try {
			PreparedStatement selectQuery = connection
					.prepareStatement("select cardnumber, pin from user_login_details where cardnumber=? and pin=?");
			selectQuery.setString(1, cardNumber);
			selectQuery.setString(2, pin);
			ResultSet result = selectQuery.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}
