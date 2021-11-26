package ezparkproject;

/* @author Conall McAteer
 * This class covers the "CC Check"
 */
public class Bank 
{
	String creditCardNumber;
	String cvvNumber;
	String expiryDate;
	
	public Bank(PaymentInformation paymentInformation) 
	{
		this.creditCardNumber = paymentInformation.getCreditCardNumber();
		this.cvvNumber = paymentInformation.getCvvNumber();
		this.expiryDate = paymentInformation.getExpiryDate();
	}
	
	public boolean validateCreditCard()
	{
		return true;
	}
}
