package com.niit.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.UserForm;

public class UserDaoTest {
	
	
	private static AnnotationConfigApplicationContext context;
	private static UserFormDao userFormDao;
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		
		System.out.println("Before");
		userFormDao=(UserFormDao)context.getBean("userFormDao");
		System.out.println("After");
		
	}
	
	@Test
	public void createUsertTest() 
	{
		UserForm userForm=new UserForm();
		userForm.setUserId(302);
		userForm.setEmailId("h2@gmail.com");
		userForm.setFirstname("Renu");
		userForm.setLastname("Rawat");
		userForm.setPasswword("renu");
		userForm.setOnline("rrrr");
		userForm.setStatus("yes");
		userForm.setRole("Admin");
		
		System.out.println("beforeTable");
				
		assertTrue("Successfully!", userFormDao.createUserForm(userForm));
		
		System.out.println("AfterTable");
	}
	

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
}
