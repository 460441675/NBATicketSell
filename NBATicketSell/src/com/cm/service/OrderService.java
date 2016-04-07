package com.cm.service;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.vo.Order;
import com.cm.vo.User;

public interface OrderService {

	boolean saveOrder(Order order);
	
	List<Order> queryOrderByUser(int userId);
	
	boolean deleteOrder(int orderId);
	
	Order findOrderById(int orderId);
	
	List<Order> queryAllOrder();
	
	PageBean getPageBean(int pageSize, int page);
	
	boolean updateOrder(Order order);
	
}
