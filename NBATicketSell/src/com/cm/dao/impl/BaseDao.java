package com.cm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {

	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
