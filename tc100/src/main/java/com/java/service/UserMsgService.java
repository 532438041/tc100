package com.java.service;

import com.java.base.BaseService;
import com.java.entity.UserMsg;

public interface UserMsgService extends BaseService<UserMsg> {

	/**
	 * 获取用户未读的消息个数
	 * 
	 * @param @param userId
	 * @param @return
	 * @return int
	 */
	int getMsgCount(String userId);
	
}