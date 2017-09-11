package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
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
		
	}
		/*try 
		{
		 sessionFactory.getCurrentSession().save(userForm);	
		  System.out.println("Insert Table");

		return true;	
		} catch(Exception e)
		{
		System.out.println("Exception Arised:" +e);	
		return false;
		}
	}
*/
	@Transactional
	public UserForm getUserForm(int userId) {
		return (UserForm) sessionFactory.getCurrentSession().get(UserForm.class, userId);
		
	//	Select * from emp_table where emp_id='123';
		
	}

	
	@Transactional
	public List<UserForm> getUserForms() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails where status='A'");
		List<UserForm> listUserForm=query.list();
		session.close();
	
		return listUserForm;
	}

	@Transactional
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

	@Transactional
	public boolean editUserForm(int userId) {
		 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		UserForm userForm = (UserForm)session.get(UserForm.class, userId);
	
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

	
	@Transactional
	public boolean deleteUserForm(int userId) {
		try {  
			Session session = sessionFactory.openSession();
			
			UserForm userForm = (UserForm)session.get(UserForm.class, userId);
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
