package amnos.management.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amnos.management.database.LoginDetails;
import amnos.management.sigup.Signup;
import amnos.management.transaction.MainFrame;

public class Login implements ActionListener {
	private JButton submit, signup, clear;
	private ImageIcon atmLogo;
	private JTextField cardNumberTextField;
	private JPasswordField pinTextField;
	JFrame frame;

	public Login() {
		// Creating a frame and adjusting the dimensions
		frame = new JFrame("Amnos - Automated Teller Machine");
		
		frame.setSize(750, 530);
		frame.setLocation(250, 100);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);

		// Adding icon to the frame....
		ImageIcon icon = new ImageIcon("src/main/java/assets/favicon.png");
		frame.setIconImage(icon.getImage());

		// Inserting the logo
		atmLogo = new ImageIcon("src/main/java/assets/atm.png");
		Image logo = atmLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		atmLogo = new ImageIcon(logo);
		JLabel logoLabel = new JLabel(atmLogo);
		logoLabel.setBounds(130, 15, 80, 80);
		frame.add(logoLabel);

		// adding the welcome text
		JLabel welcomeText = new JLabel("Welcome to ATM");
		welcomeText.setFont(new Font("Osward", Font.BOLD, 40));
		welcomeText.setBounds(250, 40, 450, 40);
		frame.add(welcomeText);

		// adding label "Card No."
		JLabel cardNumberLabel = new JLabel("Card No:");
		cardNumberLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		cardNumberLabel.setBounds(200, 150, 100, 25);
		frame.add(cardNumberLabel);

		// input field for card no.
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(300, 150, 200, 25);
		cardNumberTextField.setFont(new Font("Arial", Font.BOLD,14));
		frame.add(cardNumberTextField);

		// adding label "Pin"
		JLabel pinLabel = new JLabel("PIN:");
		pinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		pinLabel.setBounds(200, 210, 100, 25);
		frame.add(pinLabel);

		// input field for pin.
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 210, 200, 25);
		frame.add(pinTextField);
		
		//adding submit button
		submit = new JButton("Submit");
		submit.setBounds(210,260,130,40);
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		frame.add(submit);
		
		//adding clear button
		clear = new JButton("Clear");
		clear.setBounds(360, 260, 130, 40);
		clear.setBackground(Color.black);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		frame.add(clear);
		
		//adding SignUp button
		signup = new JButton("Sign Up");
		signup.setBounds(210, 310, 280,40);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		frame.add(signup);
		
		JLabel signupText = new JLabel("New members, Click on Sign Up");
		signupText.setBounds(250, 350, 280, 20);
		signupText.setFont(new Font("Italic",Font.ITALIC,15));
		frame.add(signupText);
		
		frame.setVisible(true);

	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == clear) {
			cardNumberTextField.setText("");
			pinTextField.setText("");
		} else if(event.getSource() == submit) {
			String cardNumber = cardNumberTextField.getText();
			String pinNumber = pinTextField.getText();
			LoginDetails database = new LoginDetails();
			boolean validity = database.checkLoginDetails(cardNumber, pinNumber);
			if(validity == true) {
				String userId = database.getUserId(cardNumber, pinNumber);
				frame.setVisible(false);
				new MainFrame(userId);
			} else {
				JOptionPane.showInternalMessageDialog(null, "Invalid Card Number/PIN");
			}
		} else if(event.getSource() == signup) {
			new Signup();
			frame.dispose();
			frame.setVisible(false);
		}
	}

}
