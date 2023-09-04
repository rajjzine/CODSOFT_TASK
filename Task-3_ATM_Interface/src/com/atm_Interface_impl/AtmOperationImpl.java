package com.atm_Interface_impl;


import com.atm_Interface.entity.ATM;
import com.atm_Interface_interface.AtmOperation_Interface;

public class AtmOperationImpl implements AtmOperation_Interface {

	ATM atm = new ATM();
	
	@Override
	public void withdrawAmount(double withdrawAmount) {
		if(withdrawAmount <= atm.getCheckBalance()) {
			System.out.println(" Collect the Cash " + withdrawAmount);
			atm.setCheckBalance(atm.getCheckBalance() - withdrawAmount);
			viewBalance();
		}
		else {
			System.out.println(" Insufficient Balance !!");
		}
	}

	@Override
	public void depositAmount(double depositAmount) {
		System.out.println(" " + depositAmount + " Deposited Successfully !!\n");
		atm.setCheckBalance(atm.getCheckBalance() + depositAmount);
		viewBalance();
	}

	@Override
	public void viewBalance() {
		System.out.println(" Available Balanace is : " + atm.getCheckBalance() + "\n");

	}

}
