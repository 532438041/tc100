package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Message;

public interface MessageService extends BaseService<Message> {

	PageResult<Message> getMsgList(PageParam<Message> pageParam);

}