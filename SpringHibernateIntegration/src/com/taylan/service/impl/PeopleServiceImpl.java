package com.taylan.service.impl;

import com.taylan.dao.PeopleDao;
import com.taylan.model.People;
import com.taylan.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	PeopleDao peopleDao;
	
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

}
