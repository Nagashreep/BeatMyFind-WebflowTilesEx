package com.srishtisiri.beatmyfind.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String userPassword;
	private String userName;
	private int userId;
	private boolean isNewUser;
	
	public boolean isNewUser() {
		return isNewUser;
	}

	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString(){
		return "UserName: "+getUserName()+" :FirstName: "+getFirstName()+" :MidName: "+" :LastName: "+getLastName()+" :Password: "+getUserPassword()+
				" :EmailAddress: "+getEmailAddress();
	}
	
}
