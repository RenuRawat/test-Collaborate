package com.niit.collaborate.RestController;



import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborate.Dao.BlogDao;
import com.niit.collaborate.Model.Blog;




@RestController
//@CrossOrigin(origins="http://http://localhost:8084")
public class BlogController {

	

	@Autowired
	BlogDao blogDao;
	
	
	
	
	
	
	

	
	@PostMapping(value="/createBlog")
	public ResponseEntity<String>createBlog(@RequestBody Blog blog)
	{
		System.out.println("*************************************1");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		if(blogDao.createBlog(blog))
		{
			System.out.println("*************************************2");
			return new ResponseEntity<String>("Blog Created", HttpStatus.OK);
		}
	  	
		else {
			return new ResponseEntity<String>("Problem in Blog Creation", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@GetMapping(value="/getAllBogs")
	public ResponseEntity<ArrayList<Blog>> getAllBogs()
	{
		ArrayList<Blog> listBlogs= new ArrayList<Blog>();
		listBlogs=(ArrayList<Blog>)blogDao.getBlogs();
		
	 return new ResponseEntity<ArrayList<Blog>>(listBlogs, HttpStatus.OK);	
	}
	
	

	@GetMapping(value="/test")
	public ResponseEntity<String> testMethod()
	{
		return new ResponseEntity<String>("Test RestController", HttpStatus.OK);
	}
	
	
	

}
