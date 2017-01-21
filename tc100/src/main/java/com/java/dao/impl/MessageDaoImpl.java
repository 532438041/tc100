package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.MessageDao;
import com.java.entity.Message;

@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message>implements MessageDao {

	@Override
	public List<Message> getMsgList(Message reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getMsgList"), reqParam);
	}

}