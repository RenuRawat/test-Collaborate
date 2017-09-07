package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.niit.collaborate.Dao.BlogDao;
import com.niit.collaborate.Model.Blog;

public class BlogDaoImpl implements BlogDao {

	
	public BlogDaoImpl(SessionFactory sessionFactory) {
		
	}

	public boolean createBlog(Blog blog) {
		
		return false;
	}

	public Blog getBlog(int blogId) {
		
		return null;
	}

	public List<Blog> getblogs() {
	
		return null;
	}

	public boolean approveBlog(Blog blog) {

		return false;
	}

	public boolean editBlog(int blogId) {
		
		return false;
	}

	public boolean deleteBlog(int blogId) {
		
		return false;
	}

}
