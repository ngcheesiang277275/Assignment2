package Assignment2;

import java.util.Scanner;

public abstract class CustomerRegistration{						//2.4 - Abstraction
	
	Scanner input = new Scanner(System.in);
	private String cardNum;
	private String exp;											//2.3 Encapsulation - private variables
	private String cvv;
	private String cardholder;
	
	public CustomerRegistration() {						
	}
	
	public void enterInfo() {
		do {
		System.out.print("Card number \t\t: ");
		cardNum = input.next();
			if(cardNum.length()!=16)
				System.out.println("\n***You should have 16 digits for your credit/debit card.\nPlease Try again\n");
		}while(cardNum.length() != 16);
		
		System.out.print("EXP(valid thru)(MM/YY)\t: ");
		exp = input.next();
		
		System.out.print("CVC/CVV\t\t\t: ");
		cvv = input.next();
		
		System.out.print("Cardholder name\t\t: ");
		input.nextLine();
		cardholder = input.nextLine();
	}
	
	public void printCustomerInfo() {							
		System.out.printf("%-20s: %s%n%-20s: %s%n%-20s: %s%n%-20s: %s%n", "Card number", cardNum, "EXP(valid thru)",
				exp, "CVC/CVV", cvv, "Cardholder name", cardholder);	
	}
	
	abstract void printInfo();									//2.4 - Abstraction
}