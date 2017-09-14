package com.niit.collaborate.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan("com.niit.collaborate")
public class WebResolver {

	
	@Bean
	public InternalResourceViewResolver getViewResolver() 
	{
		InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
		internalResolver.setPrefix("/WEB_INF/");
		internalResolver.setSuffix(".jsp");
		
		System.out.println("ViewResolver is Created");
		
		
		return internalResolver;
	}
	
	
   /* public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
      configurer.enable();
}
	
	
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
		
	}*/
	
	
}
