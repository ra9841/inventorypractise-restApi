package com.rabin.inventorystock.restApiproject.vo;

public class AccountDetailVo {
	private String accountHolderName;
	private String accountNumber;
	private String accountType;

	
	public AccountDetailVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDetailVo(String accountHolderName, String accountNumber, String accountType) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
