package com.taylan.service;

import java.util.List;

import com.taylan.model.People;

/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */


public interface PeopleService {
	void savePeople(People people);
	
	void updatePeople(People people);

	void deletePeople(People people);

	People getPeopleById(Integer id);
	
	List<People> listPeople();
	
}
