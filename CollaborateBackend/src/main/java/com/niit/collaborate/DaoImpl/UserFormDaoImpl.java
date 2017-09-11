package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.Blog;
import com.niit.collaborate.Model.Friend;
import com.niit.collaborate.Model.Jobs;
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
		return (UserForm) sessionFactory.getCurrentSession().get(UserForm.class, userFormId);
	}

	
	public List<UserForm> getUserForms() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<UserForm> listUserForm=query.list();
		session.close();
	
		return listUserForm;
	}

	public boolean approveUserForm(UserForm userForm) {
		try {
			userForm.setStatus("A");
			sessionFactory.getCurrentSession().save(userForm);	
			System.out.println("Approve");
			return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
		

	}

	
	public boolean editUserForm(int userFormId) {
		 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		UserForm userForm = (UserForm)session.get(UserForm.class, userFormId);
	
	    session.update(userForm);
		 System.out.println("Update the table");
		 session.close();
		 return true;
		  }
		  catch(Exception e) 
		  {
			 System.out.println("Exception Arised:"+e); 
			  return false; 
		  }
	}

	
	public boolean deleteUserForm(int userFormId) {
		try {  
			Session session = sessionFactory.openSession();
			
			UserForm userForm = (UserForm)session.get(UserForm.class, userFormId);
	        session.delete(userForm);
	        session.flush();
	        session.close();
	        return true;
	      } catch(Exception e) {
				System.out.println("Exception Arised:"+e); 
				return false;
			}
	}

}
