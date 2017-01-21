package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.UserMsgDao;
import com.java.entity.UserMsg;
import com.java.service.UserMsgService;

@Service
public class UserMsgServiceImpl extends BaseServiceImpl<UserMsg>implements UserMsgService {
	
	@Autowired
	private UserMsgDao userMsgDao;
	
	@Override
	public int getMsgCount(String userId) {
		return userMsgDao.getMsgCount(userId);
	}
}