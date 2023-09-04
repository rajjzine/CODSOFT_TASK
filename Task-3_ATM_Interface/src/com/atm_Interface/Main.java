package com.atm_Interface;

import java.util.Scanner;

import com.atm_Interface_impl.AtmOperationImpl;
import com.atm_Interface_interface.AtmOperation_Interface;

public class Main {
	public static void main(String[] args) {
		AtmOperation_Interface obj = new AtmOperationImpl();
		int atmnumber = 12345;
		int atmpin = 123;

		Scanner sc = new Scanner(System.in);
		System.out.println("====================================================");
		System.out.println("");

		System.out.println("------------ Welcome to ATM Machine :) ------------ ");
		System.out.println("");
		System.out.print(" Enter ATM number here : ");
		int atmNumber = sc.nextInt();
		//System.out.println("");
		System.out.print(" Enter ATM pin : ");
		int atmPin = sc.nextInt();

		if ((atmnumber == atmNumber) && (atmpin == atmPin)) {
			System.out.println("");
			while (true) {
				System.out.println(" 1.Withdraw Amount\n 2.Deposit Amount\n 3.Check Balanace\n 4.Exit");
				System.out.println("");
				System.out.print(" Please choice : ");
				int choise = sc.nextInt();

				if (choise == 1) {
					System.out.print(" Enter Amount to Withdraw : ");
					double withdrawAmount = sc.nextDouble();
					obj.withdrawAmount(withdrawAmount);
				} else if (choise == 2) {
					System.out.print(" Enter Amount to Deposit : ");
					double depositAmount = sc.nextDouble();
					obj.depositAmount(depositAmount);
				} else if (choise == 3) {
					obj.viewBalance();
				}  else if (choise == 4) {
					System.out.println(" Collect your ATM Card\n              Thank You....!!!!");
					System.exit(0);
				} else {
					System.out.println(" Please enter correct Choice..!");
				}
			}
		} else {
			System.out.println(" Incorrect ATM Number or Pin !");
			System.exit(0);
		}
	}
}
