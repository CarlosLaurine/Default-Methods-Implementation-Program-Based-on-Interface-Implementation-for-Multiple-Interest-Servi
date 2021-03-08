package services.interfaces;

import java.security.InvalidParameterException;

public interface InterestServiceInterface {

	double getInterestRate();
	
	/*Abstract Method payment implemented to ensure re-use among 
	  all other Interest Service Subtype Classes
	  */

	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		/*Basic Programming Algorithm Logic using Math.pow method 
		  to calculate the Total Payment based on the Net Amount 
		  and the number of Months. Since it needs the attribute
		  "interestRate" to function but Interfaces can't have
		  attributes, it passes the non-abstract method getInterestRate
		  from the Interface's Contract as the attribute, which
		  will be auto-completed when a concrete class(such as
		  EnglandInterestService and ChinaInterestService) implements
		  InterestServiceInterface
		 */
		
		return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
	}
}