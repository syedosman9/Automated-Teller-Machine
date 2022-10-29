package amnos.management.transaction;

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

import amnos.management.database.ResetPin;

public class ChangePin implements ActionListener{
	String userId;
	JFrame myFrame;
	JPasswordField oldPinTextField, newPinTextField, rePinTextField;
	JButton submit, clear;

	public ChangePin(String userId) {
		this.userId = userId;

		myFrame = new JFrame();
		myFrame.setSize(900, 730);
		myFrame.setLocation(300, 10);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(null);
		//myFrame.setUndecorated(true);

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
		
		JLabel changePin = new JLabel("Change your PIN");
		changePin.setFont(new Font("Raleway", Font.BOLD, 25));
		changePin.setBounds(220, 250, 700, 35);
		changePin.setForeground(Color.white);
		backGround.add(changePin);
		
		JLabel oldPinLabel = new JLabel("Old PIN:");
		oldPinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		oldPinLabel.setBounds(160, 310, 100, 25);
		oldPinLabel.setForeground(Color.white);
		backGround.add(oldPinLabel);
		
		oldPinTextField = new JPasswordField();
		oldPinTextField.setFont(new Font("Raleway",Font.BOLD, 20));
		oldPinTextField.setBounds(340, 310, 150, 25);
		backGround.add(oldPinTextField);
		
		JLabel newPinLabel = new JLabel("New PIN:");
		newPinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		newPinLabel.setBounds(160, 345, 100, 25);
		newPinLabel.setForeground(Color.white);
		backGround.add(newPinLabel);
		
		newPinTextField = new JPasswordField();
		newPinTextField.setFont(new Font("Raleway",Font.BOLD, 20));
		newPinTextField.setBounds(340, 345, 150, 25);
		backGround.add(newPinTextField);
		
		JLabel rePinLabel = new JLabel("Confirm New PIN:");
		rePinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		rePinLabel.setBounds(160, 380, 170, 25);
		rePinLabel.setForeground(Color.white);
		backGround.add(rePinLabel);
		
		rePinTextField = new JPasswordField();
		rePinTextField.setFont(new Font("Raleway",Font.BOLD, 20));
		rePinTextField.setBounds(340, 380, 150, 25);
		backGround.add(rePinTextField);
		
		submit = new JButton("Submit");
		submit.setBounds(360, 425, 150, 28);
		submit.addActionListener(this);
		backGround.add(submit);
		
		clear = new JButton("Clear");
		clear.setBounds(160,425,150,28);
		clear.addActionListener(this);
		backGround.add(clear);
		
		
		
		myFrame.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == clear) {
			oldPinTextField.setText("");
			newPinTextField.setText("");
			rePinTextField.setText("");
		} else if (event.getSource() == submit) {
			String oldPin = oldPinTextField.getText();
			String newPin = newPinTextField.getText();
			String rePin = rePinTextField.getText();
			if(oldPin.equals("") || oldPin.length() !=4) {
				JOptionPane.showMessageDialog(null, "Enter 4-digits current PIN");
			} else if(newPin.equals("") || newPin.length() != 4) {
				JOptionPane.showMessageDialog(null, "Enter 4-digits new PIN");
			}  else {
				if(newPin.equals(rePin)) {
					ResetPin database = new ResetPin();
					database.changePin(userId, oldPin, newPin);
					JOptionPane.showMessageDialog(null, "PIN changed ");
					System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null, "New Pin and Confirm Pin does not match");
					}
			}
			
			
		}
	}
	
	
	
	
	
	
	
	public static void main(String args[]) {
		new ChangePin("12345");
	}
}
