package amnos.management.transaction;

import java.util.Random;

public class GenerateTransactionId {
	
	public static String transactionId(String type) {
		Random random = new Random();
		if(type == "Deposit") {
			String transactionId ="CRE"+ Math.abs((random.nextLong() % 90000000L) + 6522267800000000L);
			return transactionId;
		}else if(type == "Withdraw") {
			String transactionId ="DEB"+ Math.abs((random.nextLong() % 90000000L) + 6522267800000000L);
			return transactionId;
		}
		return "";
	}
}
