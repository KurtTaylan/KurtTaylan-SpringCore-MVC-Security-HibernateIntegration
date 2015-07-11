package com.taylan.dao;

import com.taylan.model.People;

public interface PeopleDao {
	
	void savePeople(People people);

	void deletePeople(People people);

	People getPeopleById(Integer id);
}
