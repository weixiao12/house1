package com.cool.daoImpl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport{
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
