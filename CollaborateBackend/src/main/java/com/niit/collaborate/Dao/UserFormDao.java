package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.UserForm;



public interface UserFormDao {
	
	public boolean createUserForm(UserForm userForm);
	
	public UserForm getUserForm(int userFormId);
	
	public List<UserForm> getUserForms();
	
	public boolean approveUserForm(UserForm userForm);
	
	public boolean editUserForm(int userFormId);
	
	public boolean deleteUserForm(int userFormId);

}
