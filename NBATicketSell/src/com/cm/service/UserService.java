package com.cm.service;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.vo.User;

public interface UserService {

	boolean saveUser(User user);
	
	User findUser(String username,String password);
	
	boolean hasUser(String username);
	
	User findUserById(int userid);
	
	boolean updateUserInfo(User user);
	
	List<User> queryAllUser();
	
	PageBean getPageBean(int pageSize, int page);
	
	boolean deleteUserById(int userId);
}
