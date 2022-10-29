package amnos.management.transaction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import amnos.management.database.Balance;

public class BalanceEnquiry {
	
	private JFrame myFrame;
	
	public BalanceEnquiry(String userId) {
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
		
		JLabel balanceLabel = new JLabel("Available Balance:");
		balanceLabel.setFont(new Font("Raleway", Font.BOLD, 20));
		balanceLabel.setBounds(180, 280, 300, 30);
		balanceLabel.setForeground(Color.white);
		backGround.add(balanceLabel);
		
		Balance dBalance = new Balance();
		String balance = "" + dBalance.getBalance(userId);
		System.out.println(balance);
		JLabel displayBalance = new JLabel(balance);
		displayBalance.setFont(new Font("Raleway", Font.BOLD, 20));
		displayBalance.setBounds(360, 280, 700, 30);
		displayBalance.setForeground(Color.white);
		backGround.add(displayBalance);
		
		
		
		myFrame.setVisible(true);
	}
	
	public static void main(String args[]) {
		new BalanceEnquiry("12345");
	}
}
