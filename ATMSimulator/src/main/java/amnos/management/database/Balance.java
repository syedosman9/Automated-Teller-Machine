package amnos.management.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends DatabaseConnection {
	
	public long getBalance(String userId) {
		try {
			PreparedStatement selectQuery = connection.prepareStatement("select balance from user_balance where user_id=?");
			selectQuery.setString(1, userId);
			ResultSet result = selectQuery.executeQuery();
			result.next();
			long balance = (long)result.getInt("balance");
			return balance;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0L;
		}
	}
	
	public void updateBalance(long balance, String userId) {
		try {
			PreparedStatement updateQuery = connection.prepareStatement("update user_balance set balance=? where user_id=?");
			updateQuery.setLong(1, balance);
			updateQuery.setString(2, userId);
			updateQuery.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void insertBalance(int balance, String userId) {
		try {
			PreparedStatement insertQuery = connection.prepareStatement("insert into user_balance values(?,?)");
			insertQuery.setString(1, userId);
			insertQuery.setInt(2, balance);
			insertQuery.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
