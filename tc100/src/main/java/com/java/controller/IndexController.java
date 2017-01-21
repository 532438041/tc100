package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.service.UserMsgService;
import com.java.utils.ToolsUtil;

@RestController
public class IndexController {

	@Autowired
	private UserMsgService userMsgService;

	/**
	 * 获取用户未读的消息个数
	 * 
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMsgCount")
	public BaseResult getMsgCount(@CookieValue("userId") String userId) {
		BaseResult baseResult = new BaseResult();
		if (ToolsUtil.isNotNull(userId)) {
			return baseResult.success(userMsgService.getMsgCount(userId));
		}
		return baseResult.failed(0, "用户未登录！");
	}
	
}
