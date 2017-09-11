package com.niit.collaborate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.UserForm;



public class UserDaoTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static UserFormDao userFormDao;
	private UserForm userForm;
	
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
		
		
		//@Ignore
		@Test
		public void createUsertTest() 
		{
			UserForm userForm=new UserForm();
			
			userForm.setUserId(2005);
			System.out.println("Id");
			userForm.setFirstname("Ja");
			System.out.println("ja");
			userForm.setLastname("OOa");
			System.out.println("ooa");
			userForm.setPasswword("rennu");
			System.out.println("renu");
			userForm.setEmailId("awp@gmail.com");
			System.out.println("gmail");
			userForm.setStatus("n");
			System.out.println("n");
			userForm.setOnline("n");
			System.out.println("n2");
			userForm.setRole("Admin");
			
			System.out.println("Admin");
			assertTrue("userDetails",userFormDao.createUserForm(userForm));
			System.out.println("Table");
//			assertTrue("This will succeed.", userDao.createUser(user));

		}
		
		
		
		@Ignore
		@Test
		public void editUserFormTest()
		{  
			
			userForm = new UserForm();
			userForm = userFormDao.getUserForm(99);						
			
			userForm.setFirstname("Ja");
			System.out.println("ja");
			userForm.setLastname("OOa");
			System.out.println("ooa");
			userForm.setPasswword("rennu");
			System.out.println("renu");
			userForm.setEmailId("awp@gmail.com");
			System.out.println("gmail");
			userForm.setStatus("n");
			System.out.println("n");
			userForm.setOnline("n");
			System.out.println("n2");
			userForm.setRole("Admin");
			
			System.out.println("Admin");
						
		    assertTrue("This will succeed", userFormDao.editUserForm(99));
		
		}
		
		
		
		@Ignore
		@Test
		public void getUserFormTest(){
			userForm = new UserForm();
			userForm = userFormDao.getUserForm(100);
			
			
			assertEquals("This will succeed.", userFormDao.getUserForm(100));
	
		}
		
		@Ignore
		@Test
		public void approveUserFormTest()
		{
			UserForm userForm=new UserForm();
        
			
		userForm = userFormDao.getUserForm(102);
        
        userForm.setFirstname("Ja");
		System.out.println("ja");
		userForm.setLastname("OOa");
		System.out.println("ooa");
		userForm.setPasswword("rennu");
		System.out.println("renu");
		userForm.setEmailId("awp@gmail.com");
		System.out.println("gmail");
		userForm.setStatus("n");
		System.out.println("n");
		userForm.setOnline("n");
		System.out.println("n2");
		userForm.setRole("Admin");
		
		System.out.println("Admin");
			
		   assertTrue("This will succeed.", userFormDao.approveUserForm(userForm));

			}
		
		
		
		@Ignore
		@Test
		public void getAllapproveuserFormListTest()
		{
		
			List<UserForm> listuserForm= userFormDao.getUserForms();
			assertTrue("No Approved Blogs", listuserForm.size()>0);
		}
		
		
		@Ignore
		@Test
		public void DeleteUserFormTest()
		{
			
			assertTrue("Problem in Deleting", userFormDao.deleteUserForm(93));
			
}

		
		

}
