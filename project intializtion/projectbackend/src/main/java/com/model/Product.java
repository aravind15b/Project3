package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.internal.NotNull;
@Component
@Entity
public class Product implements Serializable {
public static final long serialVersionUID=4L;
@Id
@GeneratedValue
int proid;

String prodname;
@NotNull
int catid;
@NotNull
int supid;
int quanity;
int price;
String prodesc;

@Transient
MultipartFile pimage;

public int getProid() {
	return proid;
}

public void setProid(int proid) {
	this.proid = proid;
}

public String getProdname() {
	return prodname;
}

public void setProdname(String prodname) {
	this.prodname = prodname;
}

public int getCatid() {
	return catid;
}

public void setCatid(int catid) {
	this.catid = catid;
}

public int getSupid() {
	return supid;
}

public void setSupid(int supid) {
	this.supid = supid;
}

public int getQuanity() {
	return quanity;
}

public void setQuanity(int quanity) {
	this.quanity = quanity;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getProdesc() {
	return prodesc;
}

public void setProdesc(String prodesc) {
	this.prodesc = prodesc;
}

public MultipartFile getPimage() {
	return pimage;
}

public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}


}
