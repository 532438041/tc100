package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.dto.UserMsgDto;
import com.java.entity.UserMsg;

public interface UserMsgService extends BaseService<UserMsg> {

	/**
	 * 获取用户消息个数
	 * @param state 
	 * @param msgType 
	 * 
	 * @param @param userId
	 * @param @return
	 * @return int
	 */
	int getMsgCount(String userId, String msgType, String state);

	List<UserMsgDto> getUserMsgList(String userId, String msgType, String state);
	
}