package com.taylan.dao;

import java.util.List;

import com.taylan.model.People;

public interface PeopleDao {
	void savePeople(People people);

	void updatePeople(People people);

	void deletePeople(People people);

	People getPeopleById(Integer id);

	List<People> listPeople();
}
