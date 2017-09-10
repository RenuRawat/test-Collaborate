package com.niit.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.JobsDao;
import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.Jobs;
import com.niit.collaborate.Model.UserForm;

public class JobsDaoTestCase {
	
	
	
	private static AnnotationConfigApplicationContext context;
	private static JobsDao jobsDao;
	
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		System.out.println("Before");
		jobsDao =(JobsDao)context.getBean("jobsDao");
		System.out.println("After");
	}
	
	
	
	@Test
	public void createUserTest() 
	{
		Jobs job=new Jobs();
		
		job.setJobId(105);
		System.out.println("Id");
		job.setJobProfile("Ja");
		System.out.println("ja");
		job.setQualification("OOa");
		System.out.println("ooa");
		job.setJobDesc("ITApp");
		System.out.println("ITApp");
		
		job.setCreateDate(new java.util.Date());
		System.out.println("date");
		job.setStatus("n");
		System.out.println("n2");
	
		assertTrue("userDetails",jobsDao.createJob(job));
		System.out.println("Table");


	}

	
	
	
	
	
	
	
	
	

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
