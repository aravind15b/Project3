package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.UserDaoImpl.CartDaoImpl;
import com.UserDaoImpl.ProductDaoImpl;
import com.model.Cart;
import com.model.Product;

@Controller
public class CartController {
@Autowired
ProductDaoImpl productDaoImpl;
@Autowired
CartDaoImpl cartDaoImpl;

@RequestMapping(value="/addToCart/{proid}")
public String addToCart(@PathVariable("proid") int proid,@RequestParam("quantity") int quantity,HttpSession session,Model m)
{
	
	Cart cart=new Cart();
	String username=(String)session.getAttribute("username");
	cart.setCartid(1001);
	cart.setProid(proid);
	cart.setQuantity(quantity);
	cart.setStatus("N");
	cart.setUsername(username); 
	Product product=productDaoImpl.getProduct(proid);
	cart.setProdname(product.getProdname());
	cart.setPrice(product.getPrice());
	cartDaoImpl.insertCart(cart);
	List<Cart> list=cartDaoImpl.retrive(username);
	m.addAttribute("cartitems", list);
	return "Cart";
}

@RequestMapping(value="/updateCartItem/{citemid}")
public String updateCartItem(@PathVariable("citemid")int citemid,@RequestParam("quantity")int quantity,HttpSession session,Model m)
{
	Cart cart=cartDaoImpl.getCart(citemid);
	
	//Validation with Product Stock
	
	productDaoImpl.getProduct(cart.getProid()).getQuanity();
	cart.setQuantity(quantity);
	cartDaoImpl.updateCart(cart);
	
	String username=(String)session.getAttribute("username");
	
    List<Cart> list=cartDaoImpl.retrive(username);
	
	m.addAttribute("cartitems", list);
	
	return "Cart";
	
}

@RequestMapping(value="/deleteCartItem/{citemid}")
public String deleteCartItem(@PathVariable("citemid")int citemid,HttpSession session,Model m)
{
	Cart cart=(Cart)cartDaoImpl.getCart(citemid);
	cartDaoImpl.removeCart(cart);
	String username=(String)session.getAttribute("username");
	List<Cart> list=cartDaoImpl.retrive(username);
	m.addAttribute("cartitems", list);
	return "Cart";
	
}
}