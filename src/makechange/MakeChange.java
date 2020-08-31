package makechange;

import java.lang.Math;

import java.util.Scanner;

public class MakeChange {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables we will use in this project
		double twenty = 20.00;
		double ten = 10.00;
		double five = 5.00;
		double one = 1.00;
		double quarter = 0.25;
		double dime = 0.10;
		double nickle = 0.05;
		double penny = 0.01;
		double changeBack = 0;
		double totalChange;

		int pennies, dimes, quarters, ones, fives, tens, twenties;
		int nickles;

		//User Story #1
		System.out.print("What is the price of the item: $");
		double price = kb.nextDouble();

		changeBack = getValidTender(price);

		if (changeBack < 0) {
			errorMessage();
		}

		if (changeBack == 0) {
			noChange();
		}

		if (changeBack > 0) {

			System.out.printf("\n" + "CHANGE DUE: %.2f%n", changeBack); // This sys out makes change back have two
																		// decimal places after total.
			System.out.println();
			System.out.println("*****BALANCE*****");

			// We will state after this sysout how much of each bill or coin we will be
			// giving back.

			twenties = (int) Math.floor(changeBack / twenty);
			tens = (int) Math.floor((changeBack - twenties * twenty) / ten);
			fives = (int) Math.floor((changeBack - twenties * twenty - tens * ten) / five);
			ones = (int) Math.floor((changeBack - twenties * twenty - tens * ten - fives * five));

			totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one;

			// correct incorrect decimal of .999999
			totalChange = Math.round(totalChange * 100.0) / 100.0;

			quarters = (int) Math.floor(totalChange / .25);

			totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter;

			// correct incorrect decimal of .999999
			totalChange = Math.round(totalChange * 100.0) / 100.0;

			dimes = (int) Math.floor(totalChange / dime);

			totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter
					- dimes * dime;

			// correct incorrect decimal of .999999
			totalChange = Math.round(totalChange * 100.0) / 100.0;

			nickles = (int) Math.floor(totalChange / nickle);
			totalChange = changeBack - twenties * twenty - tens * ten - fives * five - ones * one - quarters * quarter
					- dimes * dime - nickles * nickle;

			// correct incorrect decimal of .999999
			totalChange = Math.round(totalChange * 100.0) / 100.0;

			pennies = (int) Math.floor(totalChange / penny);

			// Prints correct change to give back
			if (twenties > 0) {
				System.out.print("***  $20.00: " + twenties + " ***" + "\n");
			}

			if (tens > 0) {
				System.out.print("***  $10.00: " + tens + " ***" + "\n");
			}

			if (fives > 0) {
				System.out.print("***  $5.00: " + fives + " ***" + "\n");
			}

			if (ones > 0) {
				System.out.print("***  $1.00: " + ones + " ***" + "\n");
			}

			if (quarters > 0) {
				System.out.print("***  $0.25: " + quarters + " ***" + "\n");
			}

			if (nickles > 0) {
				System.out.print("***  $0.05: " + nickles + " ***" + "\n");
			}
			if (pennies > 0) {
				System.out.print("***  $0.01: " + pennies + " ***" + "\n");
			}

			System.out.println("*****************");

			kb.close();
		}
	}

	public static void noChange() {
		System.out.println("You have entered the correct change.");
		System.out.println();
		System.out.println("***BALANCE***");
		System.out.println("***  $0   ***");
		System.out.println("***BALANCE***");
		System.out.println();
		System.out.println("Thank you and have a wonderful day.");
	}

	public static void errorMessage() {
		System.out.println("The amount tendered does not meet the required cost. Please provide sufficient funds.");
	}

	public static double getValidTender(double priceArg) {

		// User Story #2 and #3. This part gave me the most trouble. Getting an error message but also looping back to providing sufficient tender.
		System.out.print("The amount tendered was: $");
		double tender = kb.nextDouble();

		double changeBack = tender - priceArg;

		if (changeBack < 0) {
			System.out.println("Please provide sufficient tender. ");
			return getValidTender(priceArg);
		} else {
			return changeBack;
		}

	}
}

