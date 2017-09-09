package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.Blog;

public interface BlogDao {

	
	public boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getBlogs();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(int blogId);
}
