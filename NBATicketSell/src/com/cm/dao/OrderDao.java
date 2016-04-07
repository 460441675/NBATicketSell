package com.cm.dao;

import java.util.List;

import com.cm.vo.Order;
import com.cm.vo.User;

public interface OrderDao {

	boolean addOrder(Order order);
	
	List<Order> queryOrderByUserId(int userId);
	
	boolean deleteOrder(int orderId);
	
	Order findOrderById(int orderId);
	
	List<Order> queryAllOrder();
	
	boolean updateOrder(Order order);
	
	
}
