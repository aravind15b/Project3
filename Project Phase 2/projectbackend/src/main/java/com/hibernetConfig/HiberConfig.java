package com.hibernetConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.UserDaoImpl.*;
import com.model.*;
import com.UserDao.*;
/*
import com.UserDao.CartDao;
import com.UserDao.CategoryDao;
import com.UserDao.ProductDao;
import com.UserDao.SupplierDao;
import com.UserDao.UserDao;
import com.UserDaoImpl.CartDaoImpl;
import com.UserDaoImpl.CategoryDaoImpl;
import com.UserDaoImpl.ProductDaoImpl;
import com.UserDaoImpl.SupplierDaoImpl;
import com.UserDaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;
*/
@Configuration 
@EnableTransactionManagement
@ComponentScan("com")
public class HiberConfig {
@Autowired
@Bean(name="datasource")
public DataSource getH2() {
	System.out.println("Hibernate initiated");
	DriverManagerDataSource dt=new DriverManagerDataSource();
	dt.setDriverClassName("org.h2.Driver");
	dt.setUrl("jdbc:h2:tcp://localhost/~/dog");
	dt.setUsername("sa");
	dt.setPassword("");
	System.out.println("conncection es");
	return dt;
}
private Properties getHiberProps(){
	Properties p=new Properties();
	p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	p.put("hibernate.show_sql","true");
	p.put("hibernate.hbm2ddl.auto", "update");
	return p;
}
	@Autowired
	@Bean(name="UserDao")
	public UserDao getUserDaoData(SessionFactory sessionFac) {
		return new UserDaoImpl(sessionFac);
	}
	@Autowired
	@Bean(name="CategoryDao")
	public CategoryDao getCategoryDaoData (SessionFactory sessionFac) {
		return new CategoryDaoImpl(sessionFac);
		
	}
	@Autowired
	@Bean(name="SupplierDao")
	public SupplierDao getSupplierDaoData(SessionFactory sessionFac) {
		return new SupplierDaoImpl(sessionFac);
	}
	@Autowired
	@Bean(name="ProductDao")
	public  ProductDao getProductDaoData(SessionFactory sessionFac) {
		return new ProductDaoImpl(sessionFac);
	}
	@Autowired
	@Bean(name="CartDao")
	public CartDao getCartDaoData(SessionFactory sessionFac) {
		return	new CartDaoImpl(sessionFac);
				}
	
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransaction(SessionFactory sessionFactory) {
		
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionFactory);
		return tm;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSession(DataSource datasource) {
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHiberProps());
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Product.class);
		lsfb.addAnnotatedClass(Cart.class);
		return lsfb.buildSessionFactory();
	}		
	
}

