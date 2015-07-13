package com.taylan.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.taylan.dao.MessageDao;
import com.taylan.model.Message;
import com.taylan.model.People;

/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */

public class MessageDaoImpl implements MessageDao {
	
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public  Message getMessage(People people) {
		
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Message.class);
		criteria.add(Restrictions.eq("people", people));
		return (Message)criteria.list();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
