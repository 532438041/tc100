package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<Active> getMyActList(String userId, String actType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("actType", actType);
		return this.getSqlSession().selectList(getStateMentName("getMyActList"), map);
	}

	@Override
	public int addViewCount(String actId) {
		return this.getSqlSession().update(getStateMentName("addViewCount"), actId);
	}

}