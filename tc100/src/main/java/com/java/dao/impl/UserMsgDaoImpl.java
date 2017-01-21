package com.java.dao.impl;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserMsgDao;
import com.java.entity.UserMsg;

@Repository
public class UserMsgDaoImpl extends BaseDaoImpl<UserMsg>implements UserMsgDao {

	@Override
	public int getMsgCount(String userId) {
		return this.getSqlSession().selectOne(getStateMentName("getMsgCount"), userId);
	}

}