package com.UserDaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.UserDao.CategoryDao;
import com.model.Category;

@Repository("categoryDAO")

public class CategoryDaoImpl implements CategoryDao{
@Autowired
SessionFactory sessionFac;
public void insertCategory(Category category) {
	
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
		session.close();
		
	}
@SuppressWarnings("unchecked")
	public List<Category> retrive() {
		
		
			Session session1=sessionFac.openSession();	
			session1.beginTransaction();
			List<Category> Categorylist = session1.createQuery("from Category").list();
			session1.getTransaction().commit();
			session1.close();	
			return Categorylist;
		
	}

public Category getCategory(int catid) {
	Session session=sessionFac.openSession();	
	Transaction tx=session.beginTransaction();
	Category p = (Category) session.load(Category.class, new Integer(catid));
	System.out.println("===================> p =" +p);
	tx.commit();
	session.close();
	return p;
	
}

public void removeCategory(Category category) {
	Session session=sessionFac.openSession();	
	session.beginTransaction();
	session.delete(category);
	session.getTransaction().commit();
	session.close();
	
}
public void updateCategory(Category category) {
	
	Session session=sessionFac.openSession();	
	session.beginTransaction();
	session.update(category);
	session.getTransaction().commit();
	session.close();

}
public CategoryDaoImpl(SessionFactory sessionFactory) {
	super();
	sessionFac=sessionFactory;	
}
}