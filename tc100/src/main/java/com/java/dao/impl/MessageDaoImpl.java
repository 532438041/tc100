package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.MessageDao;
import com.java.dto.MsgDto;
import com.java.entity.Message;

@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message>implements MessageDao {

	@Override
	public List<MsgDto> getMsgList(Message reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getMsgList"), reqParam);
	}

	@Override
	public String getLastMsgTime(String userId) {
		return this.getSqlSession().selectOne(getStateMentName("getLastMsgTime"), userId);
	}

	@Override
	public int getMyMsgCount(String userId) {
		return this.getSqlSession().selectOne("getMyMsgCount", userId);
	}

	@Override
	public MsgDto getMsg(String msgId) {
		return this.getSqlSession().selectOne("getMsg", msgId);
	}

}