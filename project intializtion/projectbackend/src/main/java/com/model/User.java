package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
@Component
@Entity

public class User implements Serializable {
private static final  long serialVersionUID =1L;
@Id
private String emailid;

private String role="Role_User";
private String password;
private String username;
private String mobile;
private String userid;
private String address;
private String country;
private boolean enable=true; 
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

public boolean isEnable() {
	return enable;
}
public void setEnable(boolean enable) {
	this.enable = enable;
}
@Override
public String toString() {
	return "User [emailid=" + emailid + ", role=" + role + ", password=" + password + ", username=" + username
			+ ", mobile=" + mobile + ", UserId=" + userid + ", address=" + address + ", country=" + country + "]";
}



}