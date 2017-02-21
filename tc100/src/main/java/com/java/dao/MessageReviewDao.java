package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.MsgReviewDto;
import com.java.entity.MessageReview;

public interface MessageReviewDao extends BaseDao<MessageReview>{

	List<MsgReviewDto> getMsgReview(String msgId);

	int getReviewCount(String userId);

}