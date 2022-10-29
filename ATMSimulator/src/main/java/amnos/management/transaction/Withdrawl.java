package amnos.management.transaction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

import amnos.management.database.Balance;
import amnos.management.database.Transactions;

public class Withdrawl implements ActionListener{

	private JFrame myFrame;
	private JFormattedTextField withdrawAmountTextField;
	private JButton withdrawButton, backButton;
	private String userId;
	
	public Withdrawl(String userId) {
		
		this.userId = userId;
		
		myFrame = new JFrame();
		myFrame.setSize(900, 730);
		myFrame.setLocation(300, 10);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(null);
		// myFrame.setUndecorated(true);

		// Adding icon to the frame....
		ImageIcon icon = new ImageIcon("src/main/java/assets/favicon.png");
		myFrame.setIconImage(icon.getImage());

		// Adding the atm background
		ImageIcon background = new ImageIcon("src/main/java/assets/atm.jpg");
		Image back = background.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
		background = new ImageIcon(back);
		JLabel backGround = new JLabel(background);
		backGround.setBounds(0, 0, 900, 730);
		myFrame.add(backGround);
		
		JLabel withdrawLabel = new JLabel("Amount to Withdrawl in your account");
		withdrawLabel.setForeground(Color.WHITE);
		withdrawLabel.setBounds(170,270,400,20);
		withdrawLabel.setFont(new Font("System", Font.BOLD,16));
		backGround.add(withdrawLabel);
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!

		withdrawAmountTextField = new JFormattedTextField(numberFormatter);
		withdrawAmountTextField.setFont(new Font("Raleway",Font.BOLD, 22));
		withdrawAmountTextField.setBounds(170, 300, 320, 25);
		backGround.add(withdrawAmountTextField);
		
		
		
		withdrawButton = new JButton("withdraw");
		withdrawButton.setBounds(360, 425, 150, 28);
		withdrawButton.addActionListener(this);
		backGround.add(withdrawButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(360,456,150,26);
		backButton.addActionListener(this);
		backGround.add(backButton);
		
		myFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == withdrawButton) {
			Long withdrawAmount = (Long)withdrawAmountTextField.getValue();
			if(withdrawAmount == null) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
			}else if(withdrawAmount % 100 != 0) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount in multiples of 100");
			}else {
				String transactionId = GenerateTransactionId.transactionId("Withdraw");
				Transactions transactionData = new Transactions();
				Balance bal = new Balance();
				long balance = bal.getBalance(userId);
				if(withdrawAmount < balance ) {
					transactionData.insertTransaction(userId, transactionId, "Withdraw", withdrawAmount);
					balance = balance - withdrawAmount;
					bal.updateBalance(balance, userId);
					JOptionPane.showMessageDialog(null, "Cash Withdraw Successfully \nAmount:"+withdrawAmount);
					myFrame.setVisible(false);
					new MainFrame(userId);
				} else {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					System.exit(0);
				}
			}
			
			
			
		} else if(event.getSource() == backButton) {
			myFrame.setVisible(false);
			new MainFrame(userId);
		}
	}
}
