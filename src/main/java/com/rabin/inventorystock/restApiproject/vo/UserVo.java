package com.rabin.inventorystock.restApiproject.vo;

import java.util.List;

import com.rabin.inventorystock.restApiproject.entity.AccountDetail;

public class UserVo {
	private String username;
	private String password;
	private String email;
	private String ssn;
	private String phoneNumber;
	private int age;
	private List<AccountDetail> accountDetail;
	
	public UserVo(String username, String password, String email, String ssn, String phoneNumber, int age,
			List<AccountDetail> accountDetail) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.accountDetail = accountDetail;
	}
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<AccountDetail> getAccountDetail() {
		return accountDetail;
	}
	public void setAccountDetail(List<AccountDetail> accountDetail) {
		this.accountDetail = accountDetail;
	}

	
	
}
