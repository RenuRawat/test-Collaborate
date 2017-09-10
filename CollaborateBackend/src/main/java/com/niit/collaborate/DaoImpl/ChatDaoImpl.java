package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.ChatDao;
import com.niit.collaborate.Model.Chat;


@Repository("chatDao")
public class ChatDaoImpl implements ChatDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ChatDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Transactional
	public boolean createChat(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);
			System.out.println("Insert the table");
		return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:" +e);
		}
		return false;
	}


	public Chat getChat(int chatId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Chat> getChats() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean approveChat(Chat chat) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editChat(int chatId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteChat(int chatId) {
		// TODO Auto-generated method stub
		return false;
	}

}
