package com.rabin.inventorystock.restApiproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rabin.inventorystock.restApiproject.encrypt.MaskData;

@Entity
@Table(name="account_detail")
public class AccountDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@MaskData
	private String accountHolderName;
	@MaskData
	private String accountNumber;
	@MaskData
	private String accountType;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	public AccountDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDetail(int id, String accountHolderName, String accountNumber, String accountType, UserEntity user) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
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
