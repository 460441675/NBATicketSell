package com.cm.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cm.dao.UserDao;
import com.cm.vo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
		return true;
	}

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from User as user where user.username=:username and user.password=:password";
		Query query = getSession().createQuery(hql);

		query.setString("username", username);
		query.setString("password", password);
		if(query.list().size() != 0){
			User user = (User) query.list().get(0);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public boolean hasUser(String username) {
		// TODO Auto-generated method stub
		String hql = "from User as user where user.username=:username";
		Query query = getSession().createQuery(hql);

		query.setString("username", username);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		String hql = "from User as user where user.userId=:userId";
		Query query = getSession().createQuery(hql);

		query.setInteger("userId", userId);
		User user = (User) query.list().get(0);
		return user;
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.username=:username, user.password=:password, user.nickname=:nickname, user.tel=:tel, user.address=:address, user.right=:right, user.idCard=:idCard, user.bankCard=:bankCard where user.userId=:userId";
		Query query = getSession().createQuery(hql);
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
		query.setString("nickname", user.getNickname());
		query.setString("tel", user.getTel());
		query.setString("address", user.getAddress());
		query.setInteger("right", user.getRight());
		query.setString("idCard", user.getIdCard());
		query.setString("bankCard", user.getBankCard());
		query.setInteger("userId", user.getUserId());
		if(query.executeUpdate()>0){
			return true;
		}
		return false;
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		List<User> list = query.list();
		return list;
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		String hql="delete from User as user where user.userId=:userId";
		Query query = getSession().createQuery(hql);
		query.setInteger("userId", userId);
		if(query.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	
}
