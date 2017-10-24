package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Cart implements Serializable {
public static final long serialVersionUID =4L;
@Id
@GeneratedValue
int citemid;
int cartid,proid,quantity,price;
String username,prodname,status;
public int getCitemid() {
	return citemid;
}
public void setCitemid(int citemid) {
	this.citemid = citemid;
}
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getProid() {
	return proid;
}
public void setProid(int proid) {
	this.proid = proid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getProdname() {
	return prodname;
}
public void setProdname(String prodname) {
	this.prodname = prodname;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
