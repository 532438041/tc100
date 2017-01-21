package com.java.dao;

import com.java.base.BaseDao;
import com.java.entity.UserMsg;

public interface UserMsgDao extends BaseDao<UserMsg> {

	int getMsgCount(String userId);
	
}