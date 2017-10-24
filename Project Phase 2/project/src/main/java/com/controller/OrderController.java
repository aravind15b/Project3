package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.UserDaoImpl.CartDaoImpl;

import com.UserDaoImpl.ProductDaoImpl;
import com.model.Cart;

@Controller
public class OrderController {
@Autowired
CartDaoImpl cartDaoImpl;
@Autowired
ProductDaoImpl productDaoImpl;
@RequestMapping("/CheckOut")
public String gotoOrder(HttpSession session,Model m) {
	String username=(String)session.getAttribute("username");
	List<Cart> list=cartDaoImpl.retrive(username);
	
	int grandtotal=0;
	for(Cart cart:list)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
	m.addAttribute("grandtotal", grandtotal);
	m.addAttribute("cartitems", list);
	return "OrderConfirm";
}
@RequestMapping("/OrderConfirm")
public String Order2() {

	return "OrderCompletion";
	
}
}

