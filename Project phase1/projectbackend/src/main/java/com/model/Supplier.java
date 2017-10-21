package com.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier implements Serializable {

@GeneratedValue 
@Id
private int supid;
private String supname,supaddress;
private static final  long serialVersionUID =3L;
public int getSupid() {
	return supid;
}
public void setSupid(int supid) {
	this.supid = supid;
}
public String getSupname() {
	return supname;
}
public void setSupname(String supname) {
	this.supname = supname;
}
public String getSupaddress() {
	return supaddress;
}
public void setSupaddress(String supaddress) {
	this.supaddress = supaddress;
}
@Override
public String toString() {
	return "Supplier [supid=" + supid + ", supname=" + supname + ", supaddress=" + supaddress + "]";
}
}
