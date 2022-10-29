package amnos.management.CardDetails;

import java.util.Random;

public class GenerateCardDetails {
	private String cardNumber;
	private String cardPinNumber;
	
	public String generateCardNumber() {
		Random random = new Random();
		cardNumber =""+ Math.abs((random.nextLong() % 90000000L) + 6522267800000000L);
		return cardNumber;
	}
	
	public String generatePInNumber() {
		Random random = new Random();
		cardPinNumber = String.format("%04d", random.nextInt(9999));
		return cardPinNumber;
	}
	
	
	public static void main(String args[]) {
		GenerateCardDetails generate =new GenerateCardDetails();
		String cardnumber = generate.generateCardNumber();
		System.out.println(cardnumber);
		String pin = generate.generatePInNumber();
		System.out.println(pin);
	}
}
