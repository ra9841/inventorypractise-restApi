package com.rabin.inventorystock.restApiproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rabin.inventorystock.restApiproject.encrypt.MaskData;



@Entity
@Table(name="user_tbl")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	@MaskData
	private String password;
	@MaskData
	private String email;
	@MaskData
	private String ssn;
	@MaskData
	private String phoneNumber;
	private int age;
	 @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="id")
	private List<AccountDetail> accountDetail;
	
	public UserEntity(int id, String username, String password, String email, String ssn, String phoneNumber, int age,
			List<AccountDetail> accountDetail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.accountDetail = accountDetail;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
