package com.niit.collaborate.config;

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


import com.niit.collaborate.DaoImpl.BlogDaoImpl;
import com.niit.collaborate.Model.Blog;

@Configuration
@ComponentScan("com.niit.collaborate")
@EnableTransactionManagement
public class DBConfig {
	
	// 1 create a DataSource obj which is used for LocalSessionFactory
	
	@Bean
	public DataSource getOracleDataSource() 
	{
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
		
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("11");
		
		System.out.println("Data Souce Created");
		
		return driverManagerDataSource ;
		
	}
	
	
	// 2 create a Hibernate property for Datasource itz mentory,,,, which is used for LocalSessionFactory
	
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		System.out.println("Hibernate property Object Created");
		
		return properties;
	}
	
	// 3 create a SessionFactory Bean.....local sessionfactory.....
	// sessionFactorydepend on ("hibernate core dependency").
	
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder= new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		System.out.println("SessionFactory Bean created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	// 4 HibernateTransaction Bean
	
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
	
		return new HibernateTransactionManager(sessionFactory);
		
	}
	
	
	// 5 Application Specific Dao bean.
	
	
	@Bean
	public BlogDaoImpl getBlogDAO(SessionFactory sessionFactory)
	{
	return new BlogDaoImpl(sessionFactory);
	}

}
