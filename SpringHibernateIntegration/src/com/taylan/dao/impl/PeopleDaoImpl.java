package com.taylan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.taylan.dao.PeopleDao;
import com.taylan.model.People;

/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */

public class PeopleDaoImpl implements PeopleDao {

	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void savePeople(People people) {
		getSessionFactory().getCurrentSession().save(people);
	}

	@Override
	@Transactional
	public void deletePeople(People people) {
		getSessionFactory().getCurrentSession().delete(people);

	}

	@Override
	@Transactional
	public People getPeopleById(Integer id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(People.class);
		criteria.add(Restrictions.eq("id", id));
		return (People) criteria.uniqueResult();
	}

	@Override
	public void updatePeople(People people) {
		getSessionFactory().getCurrentSession().update(people);

	}

	@Override
	@Transactional
	public List<People> listPeople() {

		@SuppressWarnings("unchecked")
		List<People> peopleList = getSessionFactory().getCurrentSession().createQuery("from People").list();

		return peopleList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
