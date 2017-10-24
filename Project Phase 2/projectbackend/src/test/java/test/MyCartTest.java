package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.UserDaoImpl.CartDaoImpl;
import com.model.Cart;

public class MyCartTest {

	@Test
	 public void intialize() {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com");
	context.refresh();
	CartDaoImpl cartDAO=(CartDaoImpl)context.getBean("cartDAO");
	Cart cart=new Cart();
	cart.setCartid(1001);
	cart.setProid(3);
	cart.setProdname("Leggin");
	cart.setPrice(12000);
	cart.setQuantity(6);
	cart.setStatus("N");
	cart.setUsername("Harini");
	cartDAO.insertCart(cart);
	System.out.println("Added To Cart");
	List<Cart> list=cartDAO.retrive("Harini");
	
	for(Cart cart2:list)
	{
		System.out.println(cart2.getCartid()+";;;");
		System.out.println(cart2.getProid()+";;;");
		System.out.println(cart2.getProdname()+";;;");
		System.out.println(cart2.getPrice()+";;;");
		System.out.println(cart2.getQuantity()+";;;");
		
	}
			
	
}
}

