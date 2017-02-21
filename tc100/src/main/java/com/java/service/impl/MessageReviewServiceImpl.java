package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.MessageReviewDao;
import com.java.dto.MsgReviewDto;
import com.java.entity.MessageReview;
import com.java.service.MessageReviewService;

@Service
public class MessageReviewServiceImpl extends BaseServiceImpl<MessageReview>implements MessageReviewService {

	@Autowired
	private MessageReviewDao messageReviewDao;

	@Override
	public List<MsgReviewDto> getMsgReview(String msgId) {
		return messageReviewDao.getMsgReview(msgId);
	}

	@Override
	public int getReviewCount(String userId) {
		return messageReviewDao.getReviewCount(userId);
	}

}