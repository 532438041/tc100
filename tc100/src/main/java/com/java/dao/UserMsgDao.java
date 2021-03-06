package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.UserMsgDto;
import com.java.entity.UserMsg;

public interface UserMsgDao extends BaseDao<UserMsg> {

	int getMsgCount(String userId, String msgType, String state);

	List<UserMsgDto> getUserMsgList(String userId, String msgType, String state);
	
}