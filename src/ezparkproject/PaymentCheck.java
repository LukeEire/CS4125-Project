package ezparkproject;

import java.sql.SQLException;

public class PaymentCheck 
{
	String creditCardNumber;
	String cvvNumber;
	String expiryDate;
	
	public PaymentCheck(PaymentInfo paymentInfo) 
	{
		this.creditCardNumber = paymentInfo.getCreditCardNumber();
		this.cvvNumber = paymentInfo.getCvvNumber();
		this.expiryDate = paymentInfo.getExpiryDate();
	}
	
	public boolean validateCreditCard()
	{
		return true;
	}
}


