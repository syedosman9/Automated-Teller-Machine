package amnos.management.sigup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import amnos.management.database.UserDetails;

public class SignUpTwo implements ActionListener {

	private JTextField customerAadharTextField, customerPanTextField;
	@SuppressWarnings("rawtypes")
	private JComboBox customerIncomeValue, customerEducationValue, customerOccupationValue;
	// private JPasswordField passwordField;
	private JButton nextButton;
	private String customerId;
	JFrame myFrame;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	SignUpTwo(String customerId) {
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
		JLabel formHeading = new JLabel("Additional Details");
		formHeading.setFont(new Font("Raleway", Font.BOLD, 22));
		formHeading.setBounds(290, 80, 200, 40);
		myFrame.add(formHeading);

		// Aadhar Number label
		JLabel aadharNumber = new JLabel("Aadhar Number:");
		aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharNumber.setBounds(100, 140, 200, 30);
		myFrame.add(aadharNumber);

		// name text field
		customerAadharTextField = new JTextField();
		customerAadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		customerAadharTextField.setBounds(300, 140, 200, 30);
		myFrame.add(customerAadharTextField);

		// Aadhar Number label
		JLabel panNumber = new JLabel("Pan Number:");
		panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
		panNumber.setBounds(100, 180, 200, 30);
		myFrame.add(panNumber);

		// name text field
		customerPanTextField = new JTextField();
		customerPanTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		customerPanTextField.setBounds(300, 180, 200, 30);
		myFrame.add(customerPanTextField);

		// Income text label
		JLabel customerIncomeLabel = new JLabel("Income:");
		customerIncomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		customerIncomeLabel.setBounds(100, 220, 100, 30);
		myFrame.add(customerIncomeLabel);

		// Income drop down field
		String incomeOptions[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "<10,00,000", "10,00,000+" };
		customerIncomeValue = new JComboBox(incomeOptions);
		customerIncomeValue.setBackground(Color.WHITE);
		customerIncomeValue.setBounds(300, 220, 200, 30);
		myFrame.add(customerIncomeValue);

		// Education Qualification label
		JLabel customerQualification = new JLabel("Education:");
		customerQualification.setFont(new Font("Raleway", Font.BOLD, 20));
		customerQualification.setBounds(100, 260, 200, 30);
		myFrame.add(customerQualification);

		// Education Drop down field
		String educationOptions[] = { "Under Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
		customerEducationValue = new JComboBox(educationOptions);
		customerEducationValue.setBounds(300, 260, 200, 30);
		customerEducationValue.setBackground(Color.WHITE);
		myFrame.add(customerEducationValue);

		// occupation label
		JLabel customerOccupationLabel = new JLabel("Occupation:");
		customerOccupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		customerOccupationLabel.setBounds(100, 300, 200, 30);
		myFrame.add(customerOccupationLabel);

		// occupation drop down box
		String occupationOptions[] = { "Self-Employed", "Bussiness", "Studnet", "Retired", "Others" };
		customerOccupationValue = new JComboBox(occupationOptions);
		customerOccupationValue.setBounds(300, 300, 200, 30);
		customerOccupationValue.setBackground(Color.WHITE);
		myFrame.add(customerOccupationValue);
		
		
		
		// Next Button
		nextButton = new JButton("Next");
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);
		nextButton.setBounds(600, 560, 100, 35);
		nextButton.addActionListener(this);
		myFrame.add(nextButton);

	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == nextButton) {
			String customerAadhar = customerAadharTextField.getText();
			String customerPan = customerPanTextField.getText();
			String customerIncome = (String)customerIncomeValue.getSelectedItem();
			String customerEducation = (String) customerEducationValue.getSelectedItem();
			String customerOccupation = (String) customerOccupationValue.getSelectedItem();
			
			if(customerAadhar.equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Aadhar Field can't be empty");
			} else if (customerPan.equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Pan Number cant't be empty");
			} else {
				UserDetails database = new UserDetails();
				database.insertAdditionalDetails(customerId,customerAadhar, customerPan, customerIncome, customerEducation, customerOccupation);
				myFrame.setVisible(false);
				new SignUpServices(customerId);
			}
		}
	}
}
