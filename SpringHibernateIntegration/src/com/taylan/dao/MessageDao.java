package com.taylan.dao;

import com.taylan.model.Message;
import com.taylan.model.People;

public interface MessageDao {
	Message getMessage(People people);
}
