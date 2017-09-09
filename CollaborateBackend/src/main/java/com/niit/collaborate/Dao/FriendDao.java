package com.niit.collaborate.Dao;

import java.util.List;


import com.niit.collaborate.Model.Friend;

public interface FriendDao {
	
	
	public boolean createForum(Friend friend);
	public Friend getFriend(int friendId);
	public List<Friend> getFriends();
	public boolean approveFriend(Friend friend);
	public boolean editFriend(int friendId);
	public boolean deleteFriend(int friendId);

}
