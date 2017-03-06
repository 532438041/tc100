package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.MsgDto;
import com.java.entity.Message;

public interface MessageDao extends BaseDao<Message>{

	List<MsgDto> getMsgList(Message reqParam);

	String getLastMsgTime(String userId);

	int getMyMsgCount(String userId);

	MsgDto getMsg(String msgId);

	List<String> getMsgRegion(String addName);

	List<MsgDto> getMyReviewList(String userId);
    
}