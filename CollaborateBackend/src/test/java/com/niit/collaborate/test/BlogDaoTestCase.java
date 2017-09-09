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
			blog.setBlogname("Rest");
			blog.setBlogContent("Rest is stand for Representational State Transfer");
			blog.setUserId("renu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
			assertTrue("This will succeed.", blogDao.createBlog(blog));

		}
		
		
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
						
		    assertEquals("This will succeed",true, blogDao.editBlog(blog));

		}
		@Ignore
		@Test
		public void getBlogTest(){
			blog = new Blog();
			blog = blogDao.getBlog(15);
			
			assertEquals("Successful",true,blog.getBlogId());
		}
		
		@Ignore
		@Test
		public void approveBlogTest()
		{
        Blog blog=new Blog();
			
			blog.setBlogId(101);
			blog.setBlogname("Rest");
			blog.setBlogContent("Rest is stand for Representational State Transfer");
			blog.setUserId("srenu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("A");
			blog.setLikes(0);
			
			assertEquals("Successful","A",((Blog) blogDao).getStatus());
		//	assertTrue("This will succeed.", blogDao.approveBlog(blog));

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
			
			blog = new Blog();
			blog = blogDao.getBlog(15);
		
			assertEquals("Successful",15,blog.getBlogId());

			}
		
		
		
		
		/*@Test
		public void test() {
			fail("Not yet implemented");
		}
*/
	}


