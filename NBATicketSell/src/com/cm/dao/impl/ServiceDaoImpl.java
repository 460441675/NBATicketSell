package com.cm.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cm.dao.ServiceDao;
import com.cm.vo.Order;
import com.cm.vo.Ticket;
import com.cm.vo.User;



public class ServiceDaoImpl extends BaseDao implements ServiceDao{

	@Override
	public int getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		int allRows = 0;
			Query query = getSession().createQuery(hql);
			allRows = query.list().size();
		return allRows;
	}

	@Override
	public List<Ticket> queryTicketByPage(String hql, int offSet, int pageSize) {
		// TODO Auto-generated method stub
			Query query = getSession().createQuery(hql).setFirstResult(offSet).setMaxResults(pageSize);
			
			List<Ticket> list = query.list();
			
			return list;
	}

	@Override
	public List<Order> queryOrderByPage(String hql, int offSet, int pageSize) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql).setFirstResult(offSet).setMaxResults(pageSize);
		
		List<Order> list = query.list();
		
		return list;
	}

	@Override
	public List<User> queryUserByPage(String hql, int offSet, int pageSize) {
		// TODO Auto-generated method stub
Query query = getSession().createQuery(hql).setFirstResult(offSet).setMaxResults(pageSize);
		
		List<User> list = query.list();
		
		return list;
	}

}
