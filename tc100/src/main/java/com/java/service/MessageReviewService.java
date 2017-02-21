package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.dto.MsgReviewDto;
import com.java.entity.MessageReview;

public interface MessageReviewService extends BaseService<MessageReview>{

	List<MsgReviewDto> getMsgReview(String msgId);

	int getReviewCount(String userId);

}