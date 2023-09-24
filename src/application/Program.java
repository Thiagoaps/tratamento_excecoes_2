package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double withdraw = sc.nextDouble();
					
			account.withdraw(withdraw);
			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (IllegalArgumentException e) {
			System.out.println("Withdraw error: " + e.getMessage());		
		}
		catch (InputMismatchException e) {
			System.out.println("Input error");
		}
				
		sc.close();
	}

}
