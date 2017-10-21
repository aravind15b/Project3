package com.UserDaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.UserDao.UserDao;
import com.model.User;
@Repository
public class UserDaoImpl implements UserDao{
@Autowired
SessionFactory sessionFac;
public void insertUser (User user) {
Session session=sessionFac.openSession();	
session.beginTransaction();
session.persist(user);
session.getTransaction().commit();
session.close();
}
@SuppressWarnings("unchecked")
public List<User> retrive() {
	Session session1=sessionFac.openSession();	
	session1.beginTransaction();
	List<User> personsList = session1.createQuery("from User").list();
	session1.getTransaction().commit();
	session1.close();	
	return personsList;
}
public User getUser(String emailid) {
		Session session=sessionFac.openSession();	
		Transaction tx=session.beginTransaction();
		//session.beginTransaction();
		User p = (User) session.load(User.class, emailid);
		System.out.println("===================> p =" +p);
		tx.commit();
		session.close();
		return p;
		}
public void updateUser(User user) {
	Session session=sessionFac.openSession();	
	session.beginTransaction();

	session.update(user);
	System.out.println("updated ="+user);
	session.getTransaction().commit();
	session.close();	
}

public void removeUser(String emailid) {
	Session session=sessionFac.openSession();	
	Transaction tx=session.beginTransaction();;
	User p = (User) session.load(User.class, new String(emailid));
	if(null != p){
		session.delete(p);}
	System.out.println("deleted =" +emailid);
	tx.commit();
	session.close();	
}

public UserDaoImpl(SessionFactory sessionFactory) {
	super();
	sessionFac=sessionFactory;
}


}
