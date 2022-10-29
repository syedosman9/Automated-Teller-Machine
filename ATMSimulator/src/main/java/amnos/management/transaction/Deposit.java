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

public class Deposit implements ActionListener{

	private JFrame myFrame;
	private JFormattedTextField depositAmountTextField;
	private JButton depositButton, backButton;
	private String userId;
	
	public Deposit(String userId) {
		
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
		
		JLabel amountDepositLabel = new JLabel("Amount to deposit in your account");
		amountDepositLabel.setForeground(Color.WHITE);
		amountDepositLabel.setBounds(170,270,400,20);
		amountDepositLabel.setFont(new Font("System", Font.BOLD,16));
		backGround.add(amountDepositLabel);
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!

		depositAmountTextField = new JFormattedTextField(numberFormatter);
		depositAmountTextField.setFont(new Font("Raleway",Font.BOLD, 22));
		depositAmountTextField.setBounds(170, 300, 320, 25);
		backGround.add(depositAmountTextField);		
		
		depositButton = new JButton("Deposit");
		depositButton.setBounds(360, 425, 150, 28);
		depositButton.addActionListener(this);
		backGround.add(depositButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(360,456,150,26);
		backButton.addActionListener(this);
		backGround.add(backButton);
		
		myFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == depositButton) {
			Long depositAmount = (Long)depositAmountTextField.getValue();
			if(depositAmount == null) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
			}
			String transactionId = GenerateTransactionId.transactionId("Deposit");
			Transactions database = new Transactions();
			database.insertTransaction(userId, transactionId, "Deposit", depositAmount);
			Balance bal = new Balance();
			long balance = bal.getBalance(userId);
			balance = balance + depositAmount;
			bal.updateBalance(balance, userId);
			JOptionPane.showMessageDialog(null, "Deposited Successfully \nAmount:"+depositAmount);
			myFrame.setVisible(false);
			new MainFrame(userId);
			
			
		} else if(event.getSource() == backButton) {
			myFrame.setVisible(false);
			new MainFrame(userId);
		}
	}
	
	public static void main(String args[]) {
		new Deposit("");
	}
}
