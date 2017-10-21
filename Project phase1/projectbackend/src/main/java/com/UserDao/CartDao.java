package com.UserDao;

import java.util.List;

import com.model.Cart;

public interface CartDao {
	public void insertCart(Cart cart);
	public Cart getCart(int citemid);
	public List<Cart> retrive(String username);
	public void removeCart(Cart cart);
	public void updateCart(Cart cart);
}
