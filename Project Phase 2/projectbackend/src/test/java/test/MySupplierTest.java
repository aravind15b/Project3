package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.UserDao.CategoryDao;
import com.UserDao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

public class MySupplierTest {
	
		@Test
		 public void intialize() {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();

			SupplierDao supplierDAO = (SupplierDao) context.getBean("supplierDAO");
			
			// insert
			Supplier supplier = new Supplier();
			//category.setCatid("1001");
			supplier.setSupname("Saree");
			supplier.setSupaddress("Wear and be Gorgeous");

			supplierDAO.insertSupplier(supplier);
			System.out.println("Supplier Inserted");
			
}
		
		}



