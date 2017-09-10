package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.UserForm;


@Repository("userFormDao")
public class UserFormDaoImpl implements UserFormDao {


	@Autowired
	SessionFactory sessionFactory;
	
	public UserFormDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createUserForm(UserForm userForm) {
		try 
		{
		Session session= sessionFactory.openSession();
		 
		  
		  // value get nd set from the User(Getter ns Setter method////
		// persist =automatic generate id
		  session.save(userForm);
		  session.close();
		  System.out.println("Insert Table");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:" +e);	
		return false;
		}
		
		
		/*try 
		{
		 sessionFactory.getCurrentSession().save(userForm);	
		 
		return true;	
		} catch(Exception e)
		{
		System.out.println("Exception Arised:" +e);	
		return false;
		}*/
	}

	
	public UserForm getUserForm(int userFormId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<UserForm> getUserForms() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveUserForm(UserForm userForm) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean editUserForm(int userFormId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteUserForm(int userFormId) {
		// TODO Auto-generated method stub
		return false;
	}

}
