package com.atm_Interface.entity;

public class ATM {
	
	private double withdrawAmount;
	private double depositAmount;
	private double checkBalance;
	
	public ATM() {
		
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getCheckBalance() {
		return checkBalance;
	}

	public void setCheckBalance(double checkBalance) {
		this.checkBalance = checkBalance;
	}
	
}

