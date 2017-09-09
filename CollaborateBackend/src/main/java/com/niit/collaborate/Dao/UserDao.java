package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.User;



public interface UserDao {
	
	
	public boolean createUser(User user);
	public User getUser(int UserId);
	public List<User> getUsers();
	public boolean approveUser(User user);
	public boolean editUserChat(int userId);
	public boolean deleteUser(int userId);

}
