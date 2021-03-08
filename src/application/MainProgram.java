package application;

import java.util.Locale;
import java.util.Scanner;

import services.ChinaInterestService;
import services.interfaces.InterestServiceInterface;

public class MainProgram {

	public static void main(String[] args) {
		//Setting decimal separators to dots (US - Style)
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();
		
		/*Since the Specific Interest Services (Such as ChinaInterestService
		  and EnglandInterestService) all implement InterestServiceInterface
		  with its Default Method "payment", the Main Program is "self-closed"
		  for future Maintenance and Changes at the following InterestService Object:
		  Only the new InterestService class implementing InterestServiceInterface
		  is required, and a subtle change at the InterestService Object "is"
		  instancing line below
		 */
		
		InterestServiceInterface is = new ChinaInterestService(2.0);
		//Making variable payment receive the processed amount through the chosen specific payment method
		double payment = is.payment(amount, months);
		
		System.out.println("Payment after " + months + " months:");
		//Formated decimal printing through String.format Method
		System.out.println(String.format("%.2f", payment));
		
		sc.close();
	}
}
