package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.UserDaoImpl.CategoryDaoImpl;
import com.model.Category;


@Controller


public class pageController {
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	public String Carousel() {
	return "index";
}
@RequestMapping("Contact")
public String Contact() {
	return "Contact";
}
@RequestMapping("Email")
public String Email() {
	return "Email";
}
@RequestMapping("Aboutus")
public String Aboutus() {
	return "Aboutus";
}
@RequestMapping("sidebar")
public String sidebar(Model m,Category category){
	
	m.addAttribute("catdetails", categoryDaoImpl.retrive());

	
	return "sidebar";
}
}
