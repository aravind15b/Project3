package com.UserDaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.UserDao.SupplierDao;

import com.model.Supplier;

@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDao {

	
	@Autowired
	SessionFactory sessionFac;
	public void insertSupplier(Supplier supplier) {
		
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public Supplier getSupplier(int supid) {
		Session session=sessionFac.openSession();	
		Transaction tx=session.beginTransaction();
		//session.beginTransaction();
		Supplier p = (Supplier) session.load(Supplier.class, supid);
		System.out.println("===================> p =" +p);
		tx.commit();
		session.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> retrive() {
		Session session1=sessionFac.openSession();	
		session1.beginTransaction();
		List<Supplier> personsList = session1.createQuery("from Supplier").list();
		session1.getTransaction().commit();
		session1.close();	
		return personsList;
	}

	
	public void updateSupplier(Supplier supplier) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();

		session.update(supplier);
		System.out.println("updated ="+supplier);
		session.getTransaction().commit();
		session.close();	
		
	}

	
	public void removeSupplier(Supplier supplier) {
		Session session=sessionFac.openSession();	
		Transaction tx=session.beginTransaction();;
			session.delete(supplier);
		System.out.println("deleted =" +supplier);
		tx.commit();
		session.close();	
		
	}

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		super();
		sessionFac=sessionFactory;
	}

	
}
