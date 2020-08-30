package makechange;

import java.lang.Math;

import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		//Variables we will use in this project
		double twenty = 20.00; 
		double ten = 10.00;
		double five = 5.00;
		double one = 1.00;
		double quarter = 0.25;
		double dime = 0.10; 
		double nickle = 0.05;
		double penny = 0.01; 
		double changeBack;
		double totalChange;
		boolean keepGoing = true;
		
		int pennies, dimes, quarters, ones, fives, tens, twenties;
		int nickles;
		
//		while (keepGoing) { //Originally wasn't going to to use while, but realized I had to use a while loop to insert break; command into code.
		//User Story #1
		System.out.print("What is the price of the item: $");
		double price = kb.nextDouble();
		//User Story #2
		System.out.print("The amount tendered was: $");
		double tender = kb.nextDouble();
		
		//User Story #3
//		Display an appropriate message if the customer 
//		provided too little money or the exact amount.
		
		changeBack = tender - price; //var for correct change from tender subtracted from price.
		System.out.printf("\n" + "CHANGE OWED: %.2f%n",changeBack);
		System.out.println();
		System.out.println("***BALANCE***");
		
		
		
		// We will state after this sysout how much of each bill or coin we will be giving back.

		twenties = (int) Math.floor(changeBack/twenty);
		tens = (int) Math.floor((changeBack - twenties * twenty)/ten);
		fives = (int) Math.floor((changeBack-twenties * twenty - tens * ten)/five);
		ones = (int) Math.floor((changeBack - twenties * twenty - tens * ten - fives * five));
        
		totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one;
		
		// correct incorrect decimal of .999999
		totalChange = Math.round(totalChange * 100.0) /100.0;
		
		quarters =  (int) Math.floor(totalChange/.25);
		
        totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter;
		
		// correct incorrect decimal of .999999
		totalChange = Math.round(totalChange * 100.0) /100.0;
		
		dimes =  (int) Math.floor(totalChange/dime);
		
		totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter - dimes * dime;
		
		// correct incorrect decimal of .999999
		totalChange = Math.round(totalChange * 100.0) /100.0;
		
		nickles =  (int) Math.floor(totalChange/nickle);
		totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter - dimes * dime - nickles * nickle;
		
		// correct incorrect decimal of .999999
		totalChange = Math.round(totalChange * 100.0) /100.0;
		
		pennies =  (int) Math.floor(totalChange/penny);
		
	// Print correct change to give back	
	
//	if (tender < price) {														// Having trouble implementing User Story #3 without implementing the rest of the if statements. 
//		System.out.print("Insufficent funds. Please provide more money: ");
//		
//	}

//	if (totalChange == changeBack) {
//			noChange();
//			break;
//		}

	if (twenties > 0)
	{
		System.out.print("$20.00: " + twenties + "\n");
	}
		
	if (tens > 0)
	{
		System.out.print("$10.00: " + tens + "\n");
	}
		
	if (fives > 0)
	{
		System.out.print("$5.00: " + fives + "\n");
	}	
	
	if (ones > 0)
	{
		System.out.print("$1.00: " + ones + "\n");
	}	
	
	if (quarters > 0)
	{
		System.out.print("$0.25: " + quarters + "\n");
	}	
		
	if (dimes > 0)
	{
		System.out.print("$0.10: " + dimes + "\n");
	}
		
	if (nickles > 0)
	{
		System.out.print("$0.05: " + nickles + "\n");
	}	
	if (pennies > 0) {
		System.out.print("$0.01: " + pennies + "\n");
		
	}

	
		kb.close();
	}
	
	public static void noChange() {
		System.out.println("Thank you and have a wonderful day.");
	}
		
	public static void errorMessage() {
			System.out.println("The amount tendered does not meet the required cost. Please provide sufficient funds.");
	}
}
//	}

