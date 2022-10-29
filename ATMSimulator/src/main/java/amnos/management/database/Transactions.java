package amnos.management.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Transactions extends DatabaseConnection{
	
	public void insertTransaction(String userId, String transactionId, String type, long amount) {
		try {
			PreparedStatement insertQuery = connection.prepareStatement("insert into transactions values(?,?,?,?,?)");
			insertQuery.setString(1, userId);
			insertQuery.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			insertQuery.setString(3, transactionId);
			insertQuery.setString(4, type);
			insertQuery.setLong(5, amount);
			insertQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getTransactions(String userId) {
		try {
			PreparedStatement selectQuery = connection.prepareStatement(
					"select transaction_date, transaction_id, type, amount from transactions where user_id= ? order by transaction_date");
			selectQuery.setString(1, userId);
			ResultSet result = selectQuery.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return (ResultSet) new Object();
		}

	}
	
	
	

}
