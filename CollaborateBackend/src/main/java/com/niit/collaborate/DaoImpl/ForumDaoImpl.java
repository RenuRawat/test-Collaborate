package com.niit.collaborate.DaoImpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.ForumDao;
import com.niit.collaborate.Model.Forum;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
    @Transactional
	
	public boolean createForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			System.out.println("Insert the table");
		return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:" +e);
		}
		return false;
	}

	
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Forum> getForums() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean approveForum(Forum forum) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean editForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

}
