package com.niit.collaborate.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.ForumDao;
import com.niit.collaborate.Model.Forum;



public class ForumDaoTestCase {


	private static AnnotationConfigApplicationContext context;
	private static ForumDao forumDao;
	private static Forum forum;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		
		forumDao =(ForumDao)context.getBean("forumDao");
	}
	//@Ignore
	@Test
	public void creatTableTest() {
	  Forum forum = new Forum();	
	  forum.setForumId(202);
	  System.out.println("add");
	  forum.setForumname("javaring");
	  System.out.println("add2");
	  forum.setForumcontent("samart technology");
	  System.out.println("add3");
	  forum.setCreateDate(new java.util.Date());
	  System.out.println("add4");
	  forum.setStatus("A");
	  System.out.println("add5");
	  forum.setUserId(110);
	  System.out.println("add6");
	  System.out.println("before Insert table");
	  assertTrue("Insert Table",forumDao.createForum(forum) );
	  System.out.println("after Insert table");
	}
	
	
	
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
