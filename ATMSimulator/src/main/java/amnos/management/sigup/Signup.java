package amnos.management.sigup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import amnos.management.database.UserDetails;

public class Signup implements ActionListener {

	private JFrame myFrame;
	private JTextField nameTextField, fathernameTextField, emailIdTextField, addressTextField, cityTextField,
			stateTextField, pinCodeTextField;
	// private JPasswordField passwordField;
	private JDateChooser birthDateChooser;
	private JRadioButton male, female;
	private ButtonGroup genderGroup;
	private JButton nextButton;

	public Signup() {
		// creating a frame
		myFrame = new JFrame("SignUp - Account Registration");
		myFrame.setSize(850, 700);
		myFrame.setLocation(300, 10);
		myFrame.setVisible(true);
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.setLayout(null);

		// adding an frame logo
		ImageIcon logo = new ImageIcon("src/main/java/assets/favicon.png");
		myFrame.setIconImage(logo.getImage());

		/*
		 * //adding registration icon ImageIcon registrationIcon = new
		 * ImageIcon("src/main/java/assets/registrationform.png"); Image
		 * registrationImage = registrationIcon.getImage().getScaledInstance(50, 50,
		 * Image.SCALE_DEFAULT); registrationIcon = new ImageIcon(registrationImage);
		 * JLabel registrationLabel = new JLabel(registrationIcon);
		 * registrationLabel.setBounds(130, 15, 50, 50); myFrame.add(registrationLabel);
		 */

		// page title
		JLabel formTitle = new JLabel("Customer Registeration Form");
		formTitle.setFont(new Font("Raleway", Font.BOLD, 38));
		formTitle.setBounds(140, 20, 600, 50);
		myFrame.add(formTitle);

		// page heading
		JLabel formHeading = new JLabel("Personal Details");
		formHeading.setFont(new Font("Raleway", Font.BOLD, 22));
		formHeading.setBounds(290, 80, 200, 40);
		myFrame.add(formHeading);

		// Label Customer full name
		JLabel customerFullName = new JLabel("Full Name:");
		customerFullName.setFont(new Font("Raleway", Font.BOLD, 20));
		customerFullName.setBounds(100, 140, 100, 30);
		myFrame.add(customerFullName);

		// name text field
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 200, 30);
		myFrame.add(nameTextField);

		// father name text label
		JLabel customerFatherName = new JLabel("Father's Name:");
		customerFatherName.setFont(new Font("Raleway", Font.BOLD, 20));
		customerFatherName.setBounds(100, 180, 200, 30);
		myFrame.add(customerFatherName);

		// father name text field
		fathernameTextField = new JTextField();
		fathernameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fathernameTextField.setBounds(300, 180, 200, 30);
		myFrame.add(fathernameTextField);

		// Date of birth label
		JLabel birthDate = new JLabel("Date of Birth");
		birthDate.setFont(new Font("Raleway", Font.BOLD, 20));
		birthDate.setBounds(100, 220, 200, 30);
		myFrame.add(birthDate);

		// Date of birth text field
		birthDateChooser = new JDateChooser();
		birthDateChooser.setBounds(300, 220, 200, 30);
		myFrame.add(birthDateChooser);

		// gender label
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 260, 200, 30);
		myFrame.add(gender);

		// gender radio button - male
		male = new JRadioButton("Male");
		male.setBounds(300, 260, 60, 30);
		male.setBackground(Color.WHITE);
		myFrame.add(male);

		// gender radio button - female
		female = new JRadioButton("Female");
		female.setBounds(400, 260, 120, 30);
		female.setBackground(Color.WHITE);
		myFrame.add(female);

		// Grouping the gender radio button
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);

		// email address text
		JLabel customerEmail = new JLabel("Email Id:");
		customerEmail.setFont(new Font("Raleway", Font.BOLD, 20));
		customerEmail.setBounds(100, 300, 200, 30);
		myFrame.add(customerEmail);

		// email text field
		emailIdTextField = new JTextField();
		emailIdTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailIdTextField.setBounds(300, 300, 400, 30);
		myFrame.add(emailIdTextField);

		// address label
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 340, 200, 30);
		myFrame.add(address);

		// address text Field
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 340, 400, 30);
		myFrame.add(addressTextField);

		// city label
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 380, 200, 30);
		myFrame.add(city);

		// city text field
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 380, 200, 30);
		myFrame.add(cityTextField);

		// state text label
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 420, 200, 30);
		myFrame.add(state);

		// state text field
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 420, 200, 30);
		myFrame.add(stateTextField);

		// pin code text label
		JLabel pinCode = new JLabel("Pin Code:");
		pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
		pinCode.setBounds(100, 460, 200, 30);
		myFrame.add(pinCode);

		// pin code text field
		pinCodeTextField = new JTextField();
		pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinCodeTextField.setBounds(300, 460, 200, 30);
		myFrame.add(pinCodeTextField);

		// Next Button
		nextButton = new JButton("Next");
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);
		nextButton.setBounds(600, 560, 100, 35);
		nextButton.addActionListener(this);
		myFrame.add(nextButton);

	}

	public void actionPerformed(ActionEvent event) {
		String customerId = String.format("%06d",new Random().nextInt(999999));
		String customerFullName = nameTextField.getText();
		String customerFatherName = fathernameTextField.getText();
		String customerBirthDate = ((JTextField) birthDateChooser.getDateEditor().getUiComponent()).getText();
		String customerGender = null;
		if (male.isSelected()) {
			customerGender = "male";
		} else if (female.isSelected()) {
			customerGender = "female";
		}
		String customerEmail = emailIdTextField.getText();
		String customerAddress = addressTextField.getText();
		String customerCity = cityTextField.getText();
		String customerState = stateTextField.getText();
		String customerPinCode = pinCodeTextField.getText();

		if (customerFullName.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Full Name is Required");
		} else if (customerFatherName.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Father Name is Required");
		} else if (customerBirthDate.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Insert Date of Birth");
		} else if (customerGender == null) {
			JOptionPane.showInternalMessageDialog(null, "Select your Gender");
		} else if (customerEmail.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Enter your Email Address");
		} else if (customerAddress.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Address field is Required");
		} else if (customerCity.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "City Field is Required");
		} else if (customerState.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "State Field is Required");
		} else if (customerPinCode.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Pin Code field cannot be empty");
		} else {
			UserDetails database = new UserDetails();
			database.insertCustomerDetails(customerId, customerFullName, customerFatherName, customerBirthDate,
					customerGender, customerEmail, customerAddress, customerCity, customerState, customerPinCode);
			myFrame.setVisible(false);
			new SignUpTwo(customerId);
		}
	}

	public static void main(String[] args) {
		new Signup();
	}
}
