package com.niit.collaborate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit.collaborate")
public class WebResolver {

	
	@Bean
	public InternalResourceViewResolver getViewResolver() 
	{
		InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
		internalResolver.setPrefix("/WEB_INF/views/");
		internalResolver.setSuffix(".jsp");
		
		System.out.println("ViewResolver is Created");
		
		
		return internalResolver;
	}
	
}
