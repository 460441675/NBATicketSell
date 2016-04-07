package com.cm.service.impl;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.dao.OrderDao;
import com.cm.dao.ServiceDao;
import com.cm.service.OrderService;
import com.cm.vo.Order;
import com.cm.vo.Ticket;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	
	private ServiceDao serviceDao;
	
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean saveOrder(Order order) {
		// TODO Auto-generated method stub
		if(orderDao.addOrder(order)) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Order> queryOrderByUser(int userId) {
		// TODO Auto-generated method stub
		List<Order> list = orderDao.queryOrderByUserId(userId);
		return list;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		if(orderDao.deleteOrder(orderId)) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Order findOrderById(int orderId) {
		// TODO Auto-generated method stub
		Order order = orderDao.findOrderById(orderId);
		return order;
	}

	@Override
	public List<Order> queryAllOrder() {
		// TODO Auto-generated method stub
		List<Order> list = orderDao.queryAllOrder();
		return list;
	}
	
	@Override
	public PageBean getPageBean(int pageSize, int page) {
		// TODO Auto-generated method stub
		
		PageBean pageBean = new PageBean();
		
		String hql = "from Order";
		
		int allRows = serviceDao.getAllRowCount(hql);
		
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		
		int currentPage = pageBean.getCurrentPage(page);
		
		int offSet = pageBean.getCurrentPageOffset(pageSize, currentPage);
		
		List<Order> list = serviceDao.queryOrderByPage(hql, offSet, pageSize);
		
		pageBean.setOrderList(list);
		
		pageBean.setAllRows(allRows);
		
		pageBean.setCurrentPage(currentPage);
		
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		if(orderDao.updateOrder(order)){
			return true;
		}else{
			return false;
		}
	}

}
