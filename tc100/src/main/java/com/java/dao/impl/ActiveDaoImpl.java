package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveDao;
import com.java.entity.Active;

@Repository
public class ActiveDaoImpl extends BaseDaoImpl<Active>implements ActiveDao {

	@Override
	public List<Active> getActiveList(Active reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getActiveList"), reqParam);
	}

}