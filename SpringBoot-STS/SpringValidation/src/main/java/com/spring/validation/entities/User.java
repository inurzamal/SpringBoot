package com.spring.validation.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {
	
	@NotBlank(message="Email can't be blank")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="Invalid Email !!")
	private String email;
	
	@Size(min=3, max=16, message="Password must be between 3 to 16 characters")
	private String password;
	
	@AssertTrue(message="Must agree the terms and conditions")
	private boolean agreed;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", agreed=" + agreed + "]";
	}	

}
