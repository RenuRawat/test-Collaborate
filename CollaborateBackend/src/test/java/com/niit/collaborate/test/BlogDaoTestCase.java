package com.niit.collaborate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.BlogDao;
import com.niit.collaborate.Model.Blog;

public class BlogDaoTestCase {

	
	   
	
	private static BlogDao blogDao;
	private Blog blog;
	
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext= new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com.niit.collaborate");
			annotationConfigAppContext.refresh();
			
	     blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
			
		}
		
		
		@Ignore
		@Test
		public void createBlogTest() 
		{
			Blog blog=new Blog();
			
			blog.setBlogId(101);
			blog.setBlogname("JavaApp");
			blog.setBlogContent("OOL");
			blog.setUserId("u@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
			assertTrue("This will succeed.", blogDao.createBlog(blog));

		}
		
	@Ignore
		@Test
		public void editBlogTest()
		{  
			
			blog = new Blog();
			blog = blogDao.getBlog(15);						
			
			blog.setBlogContent("It is stand for Representational State Transfer");
			blog.setUserId("srenu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
						
		    assertEquals("This will succeed",true, blogDao.editBlog(15));

		}
		
		
		@Ignore
		@Test
		public void getBlogTest(){
			blog = new Blog();
			blog = blogDao.getBlog(17);
			
		//	assertEquals("This will succeed.", blogDao.getBlog(14));
			assertEquals("Successful","Rest",blog.getBlogname());
		}
		
		@Ignore
		@Test
		public void approveBlogTest()
		{
        Blog blog=new Blog();
			
			blog.setBlogId(1);
			blog.setBlogname("Rest");
			blog.setBlogContent("Rest is stand for Representational State Transfer");
			blog.setUserId("srenu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("A");
			blog.setLikes(0);
			
		   assertTrue("This will succeed.", blogDao.approveBlog(blog));

			}
		
		
		
		@Ignore
		@Test
		public void getAllapproveBlogListTest()
		{
		
			List<Blog> listBlog= blogDao.getBlogs();
			assertTrue("No Approved Blogs", listBlog.size()>0);
		}
		
		
		@Ignore
		@Test
		public void DeleteBlogTest()
		{
			
			assertTrue("Problem in Deleting", blogDao.deleteBlog(16));
			
}

			
		
		
		
		
		/*@Test
		public void test() {
			fail("Not yet implemented");
		}
*/
	}


