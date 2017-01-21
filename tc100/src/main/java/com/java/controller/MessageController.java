package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Message;
import com.java.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * 获取同城搜列表
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMsgList")
	public BaseResult getMsgList(@RequestBody PageParam<Message> pageParam) {
		return new BaseResult().success(messageService.getMsgList(pageParam));
	}

}
