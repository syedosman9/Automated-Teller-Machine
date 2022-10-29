package amnos.management.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetails extends DatabaseConnection{

	

	public UserDetails() {
		
	} // Constructor

	public void insertCustomerDetails(String customerId, String customerName, String fatherName, String DateofBirth,
			String gender, String email, String address, String city, String state, String pinCode) {
		try {
			// prepare sql query for inserting the data into database
			PreparedStatement sqlQuery = connection
					.prepareStatement("insert into user_personal_details values(?,?,?,?,?,?,?,?,?,?)");
			sqlQuery.setString(1, customerId);
			sqlQuery.setString(2, customerName);
			sqlQuery.setString(3, fatherName);
			sqlQuery.setString(4, DateofBirth);
			sqlQuery.setString(5, gender);
			sqlQuery.setString(6, email);
			sqlQuery.setString(7, address);
			sqlQuery.setString(8, city);
			sqlQuery.setString(9, state);
			sqlQuery.setString(10, pinCode);
			sqlQuery.executeUpdate();

		} catch (SQLException e) {
			// Sql query exception
			e.printStackTrace();
		}
	}

	public void insertAdditionalDetails(String customerId, String customerAadhar, String customerPan,
			String customerIncome, String customerEducation, String customerOccupation) {
		try {
			PreparedStatement insertQuery = connection
					.prepareStatement("insert into user_additional_details values(?,?,?,?,?,?)");
			insertQuery.setString(1, customerId);
			insertQuery.setString(2, customerAadhar);
			insertQuery.setString(3, customerPan);
			insertQuery.setNString(4, customerIncome);
			insertQuery.setNString(5, customerEducation);
			insertQuery.setString(6, customerOccupation);
			insertQuery.executeUpdate();
		} catch (SQLException e) {
			// Sql query exception
			e.printStackTrace();
		}
	}

	public void insertAccountDetails(String customerId, String customerCardNumber, String customerPinNumber,
			String customerAccountType, String servicesReqired) {
		try {
			PreparedStatement insertQuery = connection
					.prepareStatement("insert into user_account_details values(?,?,?,?,?)");
			insertQuery.setString(1, customerId);
			insertQuery.setString(2, customerAccountType);
			insertQuery.setString(3, customerCardNumber);
			insertQuery.setString(4, customerPinNumber);
			insertQuery.setString(5, servicesReqired);
			insertQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUserDetails(String customerId) {
		try {
			Statement deleteQuery = connection.createStatement();
			deleteQuery.addBatch("delete from user_personal_details where sno ='" + customerId + "'");
			deleteQuery.addBatch("delete from user_additional_details where sno ='" + customerId + "'");
			deleteQuery.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	

	public String getCardNumber(String userId) {
		try {
			PreparedStatement selectQuery = connection
					.prepareStatement("select cardnumber from user_account_details where user_id=?");
			selectQuery.setString(1, userId);
			ResultSet result = selectQuery.executeQuery();
			if (result.next()) {

				return result.getString("cardnumber");
			} else {
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

}
