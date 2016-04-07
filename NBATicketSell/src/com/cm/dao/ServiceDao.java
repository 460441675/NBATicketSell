package com.cm.dao;

import java.util.List;

import com.cm.vo.Order;
import com.cm.vo.Ticket;
import com.cm.vo.User;

public interface ServiceDao {

	int getAllRowCount(String hql);
	
	List<Ticket> queryTicketByPage(String hql, int offSet, int pageSize);

	List<Order> queryOrderByPage(String hql, int offSet, int pageSize);
	
	List<User> queryUserByPage(String hql, int offSet, int pageSize);
}
