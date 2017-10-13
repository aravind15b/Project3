package com.UserDao;

import java.util.List;
import com.model.Product;

public interface ProductDao {
	public void insertProduct(Product product);
	public Product getProduct(int proid);
	public List<Product> retrive();
	public void removeProduct(Product product);
	public void updateProduct(Product product);
}
