package com.UserDaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.UserDao.ProductDao;
import com.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao  {
	@Autowired
	SessionFactory sessionFac;
	
	
	public void insertProduct(Product product) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		session.close();
		
	}


	public Product getProduct(int proid) {
		Session session=sessionFac.openSession();	
		Transaction tx=session.beginTransaction();
		//session.beginTransaction();
		Product p = (Product) session.load(Product.class, proid);
		System.out.println("===================> p =" +p);
		tx.commit();
		session.close();
		return p;
	}

	
	public List<Product> retrive() {
		Session session1=sessionFac.openSession();	
		session1.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> personsList = session1.createQuery("from Product").list();
		session1.getTransaction().commit();
		session1.close();	
		return personsList;
	}

	public void removeProduct(Product product) {
	
		Session session=sessionFac.openSession();	
		Transaction tx=session.beginTransaction();;
			session.delete(product);
		System.out.println("deleted =" +product);
		tx.commit();
		session.close();	
	}


	public void updateProduct(Product product) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();

		session.update(product);
		System.out.println("updated ="+product);
		session.getTransaction().commit();
		session.close();	
		
		
	}


	public ProductDaoImpl(SessionFactory sessionFactory) {
		super();
		sessionFac=sessionFactory;
	}

}
