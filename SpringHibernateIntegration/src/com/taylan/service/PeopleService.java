package com.taylan.service;

import com.taylan.model.People;

public interface PeopleService {
	void savePeople(People people);

	void deletePeople(People people);

	People getPeopleById(Integer id);
	
}
