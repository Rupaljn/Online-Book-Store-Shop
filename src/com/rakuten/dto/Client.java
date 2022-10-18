package com.rakuten.dto;

import java.util.Date;

import com.rakuten.exceptions.DataInvaildException;

public class Client extends BaseBean {
private String name;
private String emailId;
private String role;
private String password;

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getName() {
	return name;
}
public void setName(String name) {
	if(name.length()<3){
		throw new DataInvaildException("Name should be grather than 3 latter");
		}
	this.name = name;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	if(emailId.length()<5){
		throw new DataInvaildException("Please enter your full email address");
	}
	
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	if(password.length()<6){
		throw new DataInvaildException("Password should be 6 charater");
	}
	this.password = password;
}
}
