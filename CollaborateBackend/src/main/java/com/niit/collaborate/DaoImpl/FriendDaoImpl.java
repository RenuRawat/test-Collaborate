package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.FriendDao;
import com.niit.collaborate.Model.Friend;


@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	
	@Transactional
	public boolean createFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch(Exception e) {
		System.out.println("Exception Arised:" +e);
		return false;
		}
	}

	
	public Friend getFriend(int friendId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Friend> getFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean approveFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean editFriend(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean deleteFriend(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

}
