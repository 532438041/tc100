package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.FeedbackDao;
import com.java.entity.Feedback;
import com.java.service.FeedbackService;
import com.java.utils.PageUtil;

@Service
public class FeedbackServiceImpl extends BaseServiceImpl<Feedback>implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	@Override
	public PageResult<Feedback> getFbList(PageParam<Feedback> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(feedbackDao.getFbList(pageParam.getReqParam()));
	}

}