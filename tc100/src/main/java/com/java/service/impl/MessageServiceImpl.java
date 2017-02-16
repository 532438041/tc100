package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.MessageDao;
import com.java.dto.MsgDto;
import com.java.entity.Message;
import com.java.service.MessageService;
import com.java.utils.PageUtil;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message>implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public PageResult<MsgDto> getMsgList(PageParam<Message> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(messageDao.getMsgList(pageParam.getReqParam()));
	}

	@Override
	public List<MsgDto> getMsgList(String userId) {
		Message message = new Message();
		message.setUserId(userId);
		return messageDao.getMsgList(message);
	}

	@Override
	public String getLastMsgTime(String userId) {
		return messageDao.getLastMsgTime(userId);
	}

	@Override
	public int getMyMsgCount(String userId) {
		return messageDao.getMyMsgCount(userId);
	}

	@Override
	public MsgDto getMsg(String msgId) {
		return messageDao.getMsg(msgId);
	}

	@Override
	public List<String> getMsgRegion(String addName) {
		return messageDao.getMsgRegion(addName);
	}

}