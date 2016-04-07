package com.cm.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cm.dao.OrderDao;
import com.cm.vo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		getSession().save(order);
		return true;
	}

	@Override
	public List<Order> queryOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "from Order order where order.user.userId=:userId";
		Query query = getSession().createQuery(hql);
		query.setInteger("userId", userId);
		List<Order> list = query.list();
		return list;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		String hql="delete from Order as order where order.orderId=:orderId";
		Query query = getSession().createQuery(hql);
		query.setInteger("orderId", orderId);
		if(query.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Order findOrderById(int orderId) {
		// TODO Auto-generated method stub
		Order order = (Order) getSession().load(Order.class, orderId);
		return order;
	}

	@Override
	public List<Order> queryAllOrder() {
		// TODO Auto-generated method stub
		String hql = "from Order";
		Query query = getSession().createQuery(hql);
		List<Order> list = query.list();
		return list;
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		
		Query query;
		try {
			String hql = "update Order order set order.orderDate=:orderDate, order.consignee=:consignee, order.address=:address, order.phone=:phone, order.highOrder=:highOrder, order.middleOrder=:middleOrder, order.lowOrder=:lowOrder, order.orderPrice=:orderPrice, order.isPay=:isPay, order.ticket=:ticket, order.user=:user where order.orderId=:orderId";
			query = getSession().createQuery(hql);
			
			query.setString("orderDate", order.getOrderDate());
			query.setString("consignee", order.getConsignee());
			query.setString("address", order.getAddress());
			query.setString("phone", order.getPhone());
			query.setInteger("highOrder", order.getHighOrder());
			query.setInteger("middleOrder", order.getMiddleOrder());
			query.setInteger("lowOrder", order.getLowOrder());
			query.setString("orderPrice", order.getOrderPrice());
			query.setString("isPay", order.getIsPay());
			query.setParameter("ticket", order.getTicket());
			query.setParameter("user", order.getUser());
			query.setInteger("orderId", order.getOrderId());
			
			if(query.executeUpdate()>0){
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

}
