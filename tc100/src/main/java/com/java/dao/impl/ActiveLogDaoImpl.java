package com.java.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveLogDao;
import com.java.entity.ActiveLog;

@Repository
public class ActiveLogDaoImpl extends BaseDaoImpl<ActiveLog>implements ActiveLogDao {

	@Override
	public int isLoged(String actId, String userId, String logType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("actId", actId);
		map.put("userId", userId);
		map.put("logType", logType);
		return this.getSqlSession().selectOne(getStateMentName("isLoged"), map);
	}

}