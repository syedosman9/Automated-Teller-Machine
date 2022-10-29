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

public class MainFrame implements ActionListener{

	private JFrame myFrame;
	private JButton cashDeposit, cashWithdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
	private String userId;
	public MainFrame(String userId) {
		
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
		
		//Adding the atm background
		ImageIcon background = new ImageIcon("src/main/java/assets/atm.jpg");
		Image back = background.getImage().getScaledInstance(900,730, Image.SCALE_DEFAULT);
		background = new ImageIcon(back);
		JLabel backGround = new JLabel(background);
		backGround.setBounds(0, 0, 900, 730);
		myFrame.add(backGround);
		
		//adding select transaction label
		JLabel selectTransactionLabel = new JLabel("Please select your Transaction");
		selectTransactionLabel.setBounds(195, 245, 700, 35);
		selectTransactionLabel.setForeground(Color.WHITE);
		selectTransactionLabel.setFont(new Font("System", Font.BOLD,20));
		backGround.add(selectTransactionLabel);
		
		cashDeposit = new JButton("Deposit");
		cashDeposit.setBounds(160, 363, 150, 28);
		cashDeposit.addActionListener(this);
		backGround.add(cashDeposit);
		
		cashWithdrawl = new JButton("Cash Withdrwal");
		cashWithdrawl.setBounds(360, 363, 150, 28);
		cashWithdrawl.addActionListener(this);
		backGround.add(cashWithdrawl);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(160, 394, 150, 28);
		fastCash.addActionListener(this);
		backGround.add(fastCash);
		
		miniStatement = new JButton("Mini-Statement");
		miniStatement.setBounds(360, 394, 150, 28);
		miniStatement.addActionListener(this);
		backGround.add(miniStatement);
		
		pinChange = new JButton("Reset PIN");
		pinChange.setBounds(160,425,150,28);
		pinChange.addActionListener(this);
		backGround.add(pinChange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(360, 425, 150, 28);
		balanceEnquiry.addActionListener(this);
		backGround.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setBounds(360,456,150,26);
		backGround.add(exit);
		
		myFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == exit) {
			System.exit(0);
		} else if(event.getSource() == cashDeposit) {
			myFrame.setVisible(false);
			new Deposit(userId);
		} else if(event.getSource() == cashWithdrawl) {
			myFrame.setVisible(false);
			new Withdrawl(userId);
		} else if(event.getSource() == fastCash){
			myFrame.setVisible(false);
			new FastCash(userId);
		} else if(event.getSource() == pinChange) {
			myFrame.setVisible(false);
			new ChangePin(userId);
		} else if(event.getSource() == balanceEnquiry) {
			myFrame.setVisible(false);
			new BalanceEnquiry(userId);
		} else if(event.getSource() == miniStatement) {
			new MiniStatement(userId);
		}
	}
	
}
