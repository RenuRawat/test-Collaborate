package com.niit.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.ChatDao;
import com.niit.collaborate.Model.Chat;
import com.niit.collaborate.Model.Jobs;




public class ChatDaoTestCase {

	
	
	private static AnnotationConfigApplicationContext context;
	private static ChatDao chatDao;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		System.out.println("Before");
		chatDao =(ChatDao)context.getBean("chatDao");
		System.out.println("After");
	}
	
	
	
	
	@Test
	public void createUserTest() 
	{
		Chat chat=new Chat();
		
		chat.setChatId(204);
		System.out.println("Id");
		chat.setChatname("Ja");
		System.out.println("ja");
		chat.setCreateDate(new java.util.Date());
		System.out.println("ooa");
		chat.setUserId(45);
		System.out.println("userId");
		
			
		assertTrue("chatDetails",chatDao.createChat(chat));
		System.out.println("Table");


	}
	
	
	
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
