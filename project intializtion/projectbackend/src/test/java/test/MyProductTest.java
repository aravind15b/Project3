package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.UserDao.ProductDao;

import com.model.Product;

public class MyProductTest {
	@Test
	 public void intialize() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		ProductDao productDao= (ProductDao) context.getBean("productDao");
		
		// insert
		Product product = new Product();
		//category.setCatid("1001");
		product.setProdname("sHark");
		product.setProdesc("Dangerous");
		
		productDao.insertProduct(product);
		System.out.println("Supplier Inserted");
		
}
	
	}


