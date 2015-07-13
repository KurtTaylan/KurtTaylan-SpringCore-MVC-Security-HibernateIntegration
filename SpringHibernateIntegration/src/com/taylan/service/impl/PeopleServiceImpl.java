package com.taylan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taylan.dao.PeopleDao;
import com.taylan.model.People;
import com.taylan.service.PeopleService;

/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */

@Service
public class PeopleServiceImpl implements PeopleService {

	private PeopleDao peopleDao;
	
	@Override
	public void savePeople(People people) {
		getPeopleDao().savePeople(people);
		
	}

	@Override
	public void deletePeople(People people) {
		getPeopleDao().deletePeople(people);
		
	}

	@Override
	public People getPeopleById(Integer id) {
		
		return getPeopleDao().getPeopleById(id);
	}

	public PeopleDao getPeopleDao() {
		return peopleDao;
	}

	public void setPeopleDao(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}

	@Override
	public void updatePeople(People people) {
		getPeopleDao().updatePeople(people);	
	}

	@Override
	public List<People> listPeople() {
		
		return getPeopleDao().listPeople();
	}

}
