package com.niit.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.collaborate.Dao.FriendDao;
import com.niit.collaborate.Model.Friend;


public class FriendDaoTestCase {
	
	
	
	private static AnnotationConfigApplicationContext context;
	private static FriendDao friendDao;
	private static Friend friend;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		
		friendDao =(FriendDao)context.getBean("friendDao");
	}
//	@Ignore
	@Test
	public void creatFriendTest() {
	  Friend friend = new Friend();	
	 
	  
	  friend.setFriendId(108);
	  System.out.println("add1");
	  friend.setStatus("samart technology");
	  System.out.println("add2");
	 
	 friend.setUserId(116);
	  
	  System.out.println("before Insert table");
	  
	  assertTrue("Insert Table",friendDao.createFriend(friend) );
	  System.out.println("after Insert table");
	}
	

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
