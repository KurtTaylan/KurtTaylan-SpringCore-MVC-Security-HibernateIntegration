package com.taylan.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.taylan.dao.PeopleDao;
import com.taylan.model.People;

public class PeopleDaoImpl implements PeopleDao  {
	
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void savePeople(People people) {
		getSessionFactory().getCurrentSession().saveOrUpdate(people);
	}
	@Transactional
	@Override
	public void deletePeople(People people) {
		getSessionFactory().getCurrentSession().delete(people);
		
	}
	@Transactional
	@Override
	public People getPeopleById(Integer id) {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(People.class);
		criteria.add(Restrictions.eq("id", id));
		return (People) criteria.uniqueResult();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
