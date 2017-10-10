package test;


	


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.UserDao.CategoryDao;
import com.model.Category;

	public class MyCategoryTest {
	
		@Test
		 public void intialize() {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();

			CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
			
			// insert
			Category category = new Category();
			//category.setCatid("1001");
			category.setCatname("Saree");
			category.setCatdesc("Wear and be Gorgeous");

			categoryDAO.insertCategory(category);
			System.out.println("Category Inserted");
			
}
		
		}

