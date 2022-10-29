package amnos.management.transaction;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import amnos.management.database.Transactions;
import amnos.management.database.UserDetails;

public class MiniStatement {

	public MiniStatement(String userId) {

		JFrame myFrame = new JFrame();
		myFrame.setSize(500, 500);
		myFrame.setLocation(30, 50);
		myFrame.setTitle("Mini Statement");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.setLayout(null);

		JLabel title = new JLabel("Amnos Bank");
		title.setFont(new Font("System", Font.BOLD, 16));
		title.setForeground(Color.BLACK);
		title.setBounds(120, 20, 100, 17);
		myFrame.add(title);

		UserDetails database = new UserDetails();
		String number = database.getCardNumber(userId);
		String cardNumber = "Card Number: " + number.substring(0, 4) + "XXXXXXXXX" + number.substring(13);
		JLabel card = new JLabel(cardNumber);
		card.setFont(new Font("System", Font.BOLD, 14));
		card.setForeground(Color.BLACK);
		card.setBounds(10, 70, 250, 17);
		myFrame.add(card);
		
		Transactions transactionData = new Transactions();
		ResultSet result = transactionData.getTransactions(userId);
		
		
		
		try {
			
			if(result.next()) {
				JLabel statementOne = new JLabel();
				myFrame.add(statementOne);
				statementOne.setText(statementOne.getText() +"   "+ result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4));
				statementOne.setBounds(10, 100, 500, 10);
			}
			if(result.next()) {
				JLabel statementTwo = new JLabel();
				myFrame.add(statementTwo);
				statementTwo.setText(statementTwo.getText() + "   "+result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4));
				statementTwo.setBounds(10, 120, 500, 10);
			}
			
			if(result.next()) {
				JLabel statementThree = new JLabel();
				myFrame.add(statementThree);
				statementThree.setText(statementThree.getText() +"   "+ result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4));
				statementThree.setBounds(10, 140, 500, 10);
			}
			
			if(result.next()) {
				JLabel statementFour = new JLabel();
				myFrame.add(statementFour);
				statementFour.setText(statementFour.getText() +"   "+ result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4));
				statementFour.setBounds(10, 160, 500, 10);
			}
			
			if(result.next()) {
				JLabel statementFive = new JLabel();
				myFrame.add(statementFive);
				statementFive.setText(statementFive.getText() +"   "+ result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4));
				statementFive.setBounds(10, 180, 500, 10);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		

		

		myFrame.setVisible(true);
	}

	public static void main(String args[]) {
		new MiniStatement("234502");
	}

}
