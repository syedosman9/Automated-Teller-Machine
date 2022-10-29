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

import amnos.management.database.Balance;
import amnos.management.login.Login;

public class FastCash implements ActionListener {

	private JFrame myFrame;
	private JButton amount100, amount500, amount1000, amount2000, amount5000, amount10000, exit;
	private String userId;

	public FastCash(String userId) {

		this.userId = userId;

		myFrame = new JFrame();
		myFrame.setSize(900, 730);
		myFrame.setLocation(300, 10);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(null);
		myFrame.setUndecorated(true);

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

		// adding select transaction label
		JLabel selectAmountLabel = new JLabel("Select Amount");
		selectAmountLabel.setBounds(245, 245, 700, 35);
		selectAmountLabel.setForeground(Color.WHITE);
		selectAmountLabel.setFont(new Font("System", Font.BOLD, 16));
		backGround.add(selectAmountLabel);

		amount100 = new JButton("Rs 100");
		amount100.setBounds(160, 363, 150, 28);
		amount100.addActionListener(this);
		backGround.add(amount100);

		amount500 = new JButton("Rs 500");
		amount500.setBounds(360, 363, 150, 28);
		amount500.addActionListener(this);
		backGround.add(amount500);

		amount1000 = new JButton("Rs 1000");
		amount1000.setBounds(160, 394, 150, 28);
		amount1000.addActionListener(this);
		backGround.add(amount1000);

		amount2000 = new JButton("Rs 2000");
		amount2000.setBounds(360, 394, 150, 28);
		amount2000.addActionListener(this);
		backGround.add(amount2000);

		amount5000 = new JButton("Rs 5000");
		amount5000.setBounds(160, 425, 150, 28);
		amount5000.addActionListener(this);
		backGround.add(amount5000);

		amount10000 = new JButton("Rs 10000");
		amount10000.setBounds(360, 425, 150, 28);
		amount10000.addActionListener(this);
		backGround.add(amount10000);

		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setBounds(360, 456, 150, 26);
		backGround.add(exit);

		myFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		long amount =0;
		
		if (event.getSource() == exit) {
			System.exit(0);
			new Login();
		} else if(event.getSource() == amount100){
			amount = 100L;
		} else if(event.getSource() == amount500) {
			amount = 500L;
		} else if(event.getSource() == amount1000) {
			amount = 1000L;
		} else if(event.getSource() == amount2000) {
			amount = 2000L;
		} else if (event.getSource() == amount5000) {
			amount = 5000L;
		} else if(event.getSource() == amount10000) {
			amount = 10000L;
		}
		
		Balance bal = new Balance();		
		long balance = bal.getBalance(userId);
		
		if(amount < balance) {
			JOptionPane.showMessageDialog(null, "Cash Withdraw Successfully \nAmount:"+amount);
			balance = balance - amount;
			bal.updateBalance(balance, userId);
			myFrame.setVisible(false);
			new Login();
			
		} else {
			JOptionPane.showMessageDialog(null, "Insufficient Balance");
		}
		
	}
}
