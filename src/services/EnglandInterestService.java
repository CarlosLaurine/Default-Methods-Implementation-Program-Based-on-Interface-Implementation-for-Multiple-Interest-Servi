package services;

import services.interfaces.InterestServiceInterface;

/* Since both EnglandInterestService and ChinaInterestService
had the same payment method body, it was erased from those
previous classes' composition and stated in an InterestService Interface
as a Default Method in order to ensure re-usage and make the program
more dynamic
*/

public class EnglandInterestService implements InterestServiceInterface {
	
	/*The getInterestRate was kept as an Override Method since it
	  depends on the interestRate attribute from EnglandInterestService.
	  Once Interfaces are not able to declare attributes in its contracts,
	  it is impossible to make the getInterestRate method an Abstract Method 
	  like the previously Override payment method*/


	private double interestRate;

	public EnglandInterestService(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}
}