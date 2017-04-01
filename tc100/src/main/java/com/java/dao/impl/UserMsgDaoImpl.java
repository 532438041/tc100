package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserMsgDao;
import com.java.dto.UserMsgDto;
import com.java.entity.UserMsg;

@Repository
public class UserMsgDaoImpl extends BaseDaoImpl<UserMsg>implements UserMsgDao {

	@Override
	public int getMsgCount(String userId, String msgType, String state) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("msgType", msgType);
		map.put("state", state);
		return this.getSqlSession().selectOne(getStateMentName("getMsgCount"), map);
	}

	@Override
	public List<UserMsgDto> getUserMsgList(String userId, String msgType, String state) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("msgType", msgType);
		map.put("state", state);
		return this.getSqlSession().selectList(getStateMentName("getUserMsgList"), map);
	}

}