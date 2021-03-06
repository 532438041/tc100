package com.java.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveDao;
import com.java.entity.Active;

@Repository
public class ActiveDaoImpl extends BaseDaoImpl<Active> implements ActiveDao {

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

	@Override
	public void operateAct(String actId, BigDecimal amount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("actId", actId);
		map.put("amount", amount);
		this.getSqlSession().update(getStateMentName("operateAct"), map);
	}

	@Override
	public List<Active> getActFBList(String userId, String actType, String state) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("actType", actType);
		map.put("state", state);
		return this.getSqlSession().selectList(getStateMentName("getActFBList"), map);
	}

	@Override
	public List<String> getActRegion(String addName, String actType) {
		Map<String, Object> map = new HashMap<>();
		map.put("addName", addName);
		map.put("actType", actType);
		return this.getSqlSession().selectList(getStateMentName("getActRegion"), map);
	}

	@Override
	public List<Active> getActList(Active reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getActList"), reqParam);
	}

	@Override
	public int upAct(Active active) {
		return this.getSqlSession().update(getStateMentName("upAct"), active);
	}

	@Override
	public List<Active> checkActName(Active reqParam) {
		return this.getSqlSession().selectList(getStateMentName("checkActName"), reqParam);
	}

}