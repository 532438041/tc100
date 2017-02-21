package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.MessageReviewDao;
import com.java.dto.MsgReviewDto;
import com.java.entity.MessageReview;

@Repository
public class MessageReviewDaoImpl extends BaseDaoImpl<MessageReview>implements MessageReviewDao {

	@Override
	public List<MsgReviewDto> getMsgReview(String msgId) {
		return this.getSqlSession().selectList(getStateMentName("getMsgReview"), msgId);
	}

	@Override
	public int getReviewCount(String userId) {
		return this.getSqlSession().selectOne(getStateMentName("getReviewCount"), userId);
	}

}