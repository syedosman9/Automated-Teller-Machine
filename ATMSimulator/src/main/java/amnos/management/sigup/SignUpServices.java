package amnos.management.sigup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import amnos.management.CardDetails.GenerateCardDetails;
import amnos.management.database.Balance;
import amnos.management.database.LoginDetails;
import amnos.management.database.UserDetails;
import amnos.management.login.Login;
import amnos.management.transaction.Deposit;

public class SignUpServices implements ActionListener{
	
	private String customerId;
	private JButton submitButton, cancelButton;
	private JRadioButton accountTypeSavings, accountTypeCurrent, accountTypeFixedDeposit, accountTypeRecurringDeposit;
	private JCheckBox atmCardBox, internetBankingBox, mobileBankingBox, notificationAlertBox, chequeBookBox,
			eStatementBox, termsBox;
	private JFrame myFrame;
	private UserDetails database;

	SignUpServices(String customerId) {
		
		this.customerId = customerId;
		
		
		// creating a frame
		myFrame = new JFrame("SignUp - Account Registration");
		myFrame.setSize(800, 700);
		myFrame.setLocation(300, 10);
		myFrame.setVisible(true);
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.setLayout(null);

		// adding an frame logo
		ImageIcon logo = new ImageIcon("src/main/java/assets/favicon.png");
		myFrame.setIconImage(logo.getImage());

		// page title
		JLabel formTitle = new JLabel("Customer Registeration Form");
		formTitle.setFont(new Font("Raleway", Font.BOLD, 38));
		formTitle.setBounds(140, 20, 600, 50);
		myFrame.add(formTitle);

		// page heading
		JLabel formHeading = new JLabel("Account Details");
		formHeading.setFont(new Font("Raleway", Font.BOLD, 22));
		formHeading.setBounds(290, 80, 200, 40);
		myFrame.add(formHeading);

		// account type label
		JLabel accountTypeLabel = new JLabel("Account Type:");
		accountTypeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		accountTypeLabel.setBounds(100, 140, 200, 30);
		myFrame.add(accountTypeLabel);

		// account type radio buttons , , ,
		accountTypeSavings = new JRadioButton("Savings Account");
		accountTypeSavings.setBounds(100, 180, 150, 30);
		accountTypeSavings.setFont(new Font("Raleway", Font.BOLD, 15));
		accountTypeSavings.setBackground(Color.WHITE);
		myFrame.add(accountTypeSavings);

		accountTypeCurrent = new JRadioButton("Current Account");
		accountTypeCurrent.setBounds(300, 180, 150, 30);
		accountTypeCurrent.setFont(new Font("Raleway", Font.BOLD, 15));
		accountTypeCurrent.setBackground(Color.WHITE);
		myFrame.add(accountTypeCurrent);

		accountTypeFixedDeposit = new JRadioButton("Fixed Deposit Account");
		accountTypeFixedDeposit.setBounds(100, 230, 200, 30);
		accountTypeFixedDeposit.setBackground(Color.WHITE);
		accountTypeFixedDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
		myFrame.add(accountTypeFixedDeposit);

		accountTypeRecurringDeposit = new JRadioButton("Recurring Deposit Account");
		accountTypeRecurringDeposit.setBounds(300, 230, 250, 30);
		accountTypeRecurringDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
		accountTypeRecurringDeposit.setBackground(Color.WHITE);
		myFrame.add(accountTypeRecurringDeposit);

		// Grouping the account type radio button
		ButtonGroup accountTypeGroup = new ButtonGroup();
		accountTypeGroup.add(accountTypeSavings);
		accountTypeGroup.add(accountTypeCurrent);
		accountTypeGroup.add(accountTypeFixedDeposit);
		accountTypeGroup.add(accountTypeRecurringDeposit);

		// service label
		JLabel servicesLabel = new JLabel("Services Required:");
		servicesLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		servicesLabel.setBounds(100, 300, 200, 30);
		myFrame.add(servicesLabel);

		// Services Req check boxes , ,, ,,
		atmCardBox = new JCheckBox("ATM Card");
		atmCardBox.setBackground(Color.WHITE);
		atmCardBox.setFont(new Font("Raleway", Font.BOLD, 15));
		atmCardBox.setBounds(100, 340, 100, 20);
		myFrame.add(atmCardBox);

		internetBankingBox = new JCheckBox("Internet Banking");
		internetBankingBox.setBackground(Color.WHITE);
		internetBankingBox.setFont(new Font("Raleway", Font.BOLD, 15));
		internetBankingBox.setBounds(300, 340, 150, 20);
		myFrame.add(internetBankingBox);

		mobileBankingBox = new JCheckBox("Mobile Banking");
		mobileBankingBox.setBackground(Color.WHITE);
		mobileBankingBox.setFont(new Font("Raleway", Font.BOLD, 15));
		mobileBankingBox.setBounds(100, 370, 150, 20);
		myFrame.add(mobileBankingBox);

		notificationAlertBox = new JCheckBox("SMS/Email Alert");
		notificationAlertBox.setBackground(Color.WHITE);
		notificationAlertBox.setFont(new Font("Raleway", Font.BOLD, 15));
		notificationAlertBox.setBounds(300, 370, 150, 20);
		myFrame.add(notificationAlertBox);

		chequeBookBox = new JCheckBox("Cheque Book");
		chequeBookBox.setBackground(Color.WHITE);
		chequeBookBox.setFont(new Font("Raleway", Font.BOLD, 15));
		chequeBookBox.setBounds(100, 400, 150, 20);
		myFrame.add(chequeBookBox);

		eStatementBox = new JCheckBox("E-Statement");
		eStatementBox.setBackground(Color.WHITE);
		eStatementBox.setFont(new Font("Raleway", Font.BOLD, 15));
		eStatementBox.setBounds(300, 400, 150, 20);
		myFrame.add(eStatementBox);

		termsBox = new JCheckBox("I accept to the Terms & Conditions as set out by the User Agreement.");
		termsBox.setBackground(Color.WHITE);
		termsBox.setFont(new Font("Raleway", Font.BOLD, 15));
		termsBox.setBounds(100, 500, 600, 20);
		myFrame.add(termsBox);

		// Next Button
		submitButton = new JButton("Sign Up");
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.setBounds(120, 560, 200, 35);
		submitButton.addActionListener(this);
		myFrame.add(submitButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(400, 560, 200, 35);
		cancelButton.addActionListener(this);
		myFrame.add(cancelButton);

	}
	
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == submitButton) {
			
			if(termsBox.isSelected()) {
				String customerAccountType = "";
				if(accountTypeSavings.isSelected()) {
					customerAccountType = "Savings Account";
				} else if(accountTypeCurrent.isSelected()) {
					customerAccountType = "Current Account";
				} else if(accountTypeFixedDeposit.isSelected()) {
					customerAccountType = "Fixed Deposit";
				}else if(accountTypeRecurringDeposit.isSelected()) {
					customerAccountType = "Recurring Deposit";
				}
				
				
				//atmCardBox, , , , ,
				//
				String customerServicesRequired = "";
				if(atmCardBox.isSelected()) {
					customerServicesRequired = customerServicesRequired + " ATM Card,";
				} 
				if(internetBankingBox.isSelected()) {
					customerServicesRequired += " InternetBanking,";
				}
				if(mobileBankingBox.isSelected()) {
					customerServicesRequired += " Mobile Banking,";
				}
				if(notificationAlertBox.isSelected()) {
					customerServicesRequired += " Notification Alert,";
				}
				if(chequeBookBox.isSelected()) {
					customerServicesRequired += " Cheque Book,";
				}
				if(eStatementBox.isSelected()) {
					customerServicesRequired += " E-Statement";
				}
				
				if(customerAccountType.equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Select the Account Type");
				}
				
				GenerateCardDetails cardDetails = new GenerateCardDetails();
				String customerCardNumber = cardDetails.generateCardNumber();
				String customerPinNumber = cardDetails.generatePInNumber();
				
				LoginDetails login = new LoginDetails();
				database = new UserDetails();
				database.insertAccountDetails(customerId,  customerCardNumber, customerPinNumber, customerAccountType, customerServicesRequired);
				login.insertLoginDetails(customerId, customerCardNumber, customerPinNumber);
				
				Balance bal = new Balance();
				bal.insertBalance(0, customerId);
				
				
				JOptionPane.showMessageDialog(null,"Card Number: " +customerCardNumber+"\n"+"Pin Number: "+ customerPinNumber );
				myFrame.setVisible(false);
				new Deposit(customerId);
				
			} else {
				JOptionPane.showInternalMessageDialog(null, "Accept the Terms & Conditions");
			}
			
			
			if(event.getSource() == cancelButton) {
				database.deleteUserDetails(customerId);
				myFrame.setVisible(false);
				new Login();
			}
		}
		
		
		
		
		
	}
	
	
}
