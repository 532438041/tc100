package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dto.MsgDto;
import com.java.entity.Message;

public interface MessageService extends BaseService<Message> {

	PageResult<MsgDto> getMsgList(PageParam<Message> pageParam);

	String getLastMsgTime(String userId);

	int getMyMsgCount(String userId);

	List<MsgDto> getMsgList(String userId);

}