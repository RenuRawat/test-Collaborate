package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.Chat;



public interface ChatDao {
	
	public boolean createChat(Chat chat);
	public Chat getChat(int chatId);
	public List<Chat> getChats();
	public boolean approveChat(Chat chat);
	public boolean editChat(int chatId);
	public boolean deleteChat(int chatId);

}
