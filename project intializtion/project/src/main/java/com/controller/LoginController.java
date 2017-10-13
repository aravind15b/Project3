package com.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.UserDaoImpl.ProductDaoImpl;
import com.UserDaoImpl.UserDaoImpl;
import com.model.Product;
import com.model.User;
@Controller
public class LoginController {
@Autowired
UserDaoImpl userDaoImpl;
@Autowired
ProductDaoImpl productDaoImpl;


@RequestMapping("/Login")
public String gotoLogin() {

	return "Login";
}
@RequestMapping("/login_success")
public String loginSuccess(HttpSession session, Model m) {
	
	String page = null;
	boolean loggedIn = true;
	// Retrieving the username;
	String username = SecurityContextHolder.getContext().getAuthentication().getName();
	session.setAttribute("username", username);
	session.setAttribute("loggedIn", loggedIn);
	
	// Retrieving the role

	@SuppressWarnings("unchecked")
	Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
			.getAuthentication().getAuthorities();
	for (GrantedAuthority role : authorities)
	{
		System.out.println("Role:" + role.getAuthority() + "UserName:" + username);
		if (role.getAuthority().equals("Role_User"))
		{
			List<Product> prodlist = productDaoImpl.retrive();
			m.addAttribute("proddetail", prodlist);
			page = "UserHome";
		} 
		else
		{
			
			page = "AdminHome";
		}
		System.out.println("Login Successfull");
	}
	return page;
	
}
}