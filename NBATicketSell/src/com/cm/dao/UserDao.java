package com.cm.dao;

import java.util.List;

import com.cm.vo.User;

public interface UserDao {

	boolean addUser(User user);
	
	User findUser(String username,String password);
	
	boolean	hasUser(String username);
	
	User findUserById(int userId);
	
	boolean updateUserInfo(User user);
	
	List<User> queryAllUser();
	
	boolean deleteUserById(int userId);
}
