package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.MessageDao;
import com.java.entity.Message;
import com.java.service.MessageService;
import com.java.utils.PageUtil;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message>implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public PageResult<Message> getMsgList(PageParam<Message> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(messageDao.getMsgList(pageParam.getReqParam()));
	}

}