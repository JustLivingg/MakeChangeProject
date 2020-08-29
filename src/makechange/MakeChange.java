package makechange;

import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		//Variables we will use in this project
		double hundreds, fifties, twenties, tens, fives, ones;
		double quarter, dimes, nickles, pennies; 
		double changeback;
		//User Story #1
		System.out.print("What is the price of the item: ");
		double price = kb.nextDouble();
		//User Story #2
		System.out.print("The amount tendered was: ");
		double tender = kb.nextDouble();
		
		//User Story #3
//		Display an appropriate message if the customer 
//		provided too little money or the exact amount.
		
		changeback = tender - price; //var for correct change from tender subtracted from price.
		
		
		kb.close();
	}
	
	public static void noChange() {
		System.out.println("Balance owed $0. Thank you and have a wonderful day.");
	}
	public static void errorMessage() {
		System.out.println("The amount tendered does not meet the required cost. Please provide sufficient funds.");
	}
}
