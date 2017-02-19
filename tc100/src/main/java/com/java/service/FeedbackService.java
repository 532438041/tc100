package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Feedback;

public interface FeedbackService extends BaseService<Feedback> {

	PageResult<Feedback> getFbList(PageParam<Feedback> pageParam);

}