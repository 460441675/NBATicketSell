package com.cm.service.impl;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.dao.ServiceDao;
import com.cm.dao.UserDao;
import com.cm.service.UserService;
import com.cm.vo.Ticket;
import com.cm.vo.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public ServiceDao serviceDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		if(hasUser(user.getUsername())){
			if (userDao.addUser(user)) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		
		return userDao.findUser(username, password);
	}

	@Override
	public boolean hasUser(String username) {
		// TODO Auto-generated method stub
		if(userDao.hasUser(username)){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User findUserById(int userid) {
		// TODO Auto-generated method stub
		
		return userDao.findUserById(userid);
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		if(userDao.updateUserInfo(user)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userDao.queryAllUser();
		return list;
	}

	@Override
	public PageBean getPageBean(int pageSize, int page) {
		// TODO Auto-generated method stub

		PageBean pageBean = new PageBean();
		
		String hql = "from User";
		
		int allRows = serviceDao.getAllRowCount(hql);
		
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		
		int currentPage = pageBean.getCurrentPage(page);
		
		int offSet = pageBean.getCurrentPageOffset(pageSize, currentPage);
		
		List<User> list = serviceDao.queryUserByPage(hql, offSet, pageSize);
		
		pageBean.setUserList(list);
		
		pageBean.setAllRows(allRows);
		
		pageBean.setCurrentPage(currentPage);
		
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		if(userDao.deleteUserById(userId)) {
			return true;
		}else{
			return false;
		}
	}

}
