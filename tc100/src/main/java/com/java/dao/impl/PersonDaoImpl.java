package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.PersonDao;
import com.java.entity.Person;

@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

	@Override
	public List<Person> getPersonList(Person reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getPersonList"), reqParam);
	}

}