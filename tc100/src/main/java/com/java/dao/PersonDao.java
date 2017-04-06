package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Person;

public interface PersonDao extends BaseDao<Person>{

	List<Person> getPersonList(Person reqParam);

}