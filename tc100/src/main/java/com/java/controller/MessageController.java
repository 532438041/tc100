package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Message;
import com.java.entity.MessageReview;
import com.java.service.MessageReviewService;
import com.java.service.MessageService;
import com.java.utils.ToolsUtil;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageReviewService messageReviewService;

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

	/**
	 * 添加、编辑同城搜
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveMsg")
	public BaseResult saveMsg(@RequestBody BaseParam<Message> baseParam) {
		baseParam.getParam().setUpdateTime(new Date());
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setCreateTime(new Date());
			return new BaseResult().success(messageService.insert(baseParam.getParam()), "操作成功！");
		} else {
			return new BaseResult().success(messageService.updateByPrimaryKeySelective(baseParam.getParam()), "操作成功！");
		}
	}

	/**
	 * 获取最后一次发布时间 用于限制同城搜信息每一小时 并且发布按钮显示倒计时
	 * 
	 * @param @param userId
	 * @param lastMsgTime
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getLastMsgTime")
	public BaseResult getLastMsgTime(@CookieValue("userId") String userId) {
		return new BaseResult().success(messageService.getLastMsgTime(userId));
	}

	/**
	 * 获取同城搜消息回复列表
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMsgReview")
	public BaseResult getMsgReview(String msgId) {
		return new BaseResult().success(messageReviewService.getMsgReview(msgId));
	}

	/**
	 * 添加同城搜消息回复
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/addMsgReview")
	public BaseResult addMsgReview(@RequestBody BaseParam<MessageReview> baseParam) {
		baseParam.getParam().setId(ToolsUtil.getUUID());
		baseParam.getParam().setCreateTime(new Date());
		baseParam.getParam().setUpdateTime(new Date());
		return new BaseResult().success(messageReviewService.insert(baseParam.getParam()));
	}

	/**
	 * 获取我的同城搜个数 我的提问个数
	 * 
	 * @param @return
	 * @return BaseResult msgCount
	 */
	@RequestMapping(value = "/getMyMsgCount")
	public BaseResult getMyMsgCount(String userId) {
		return new BaseResult().success(messageService.getMyMsgCount(userId));
	}

	/**
	 * 我的同城搜列表 及回复的个数（我的提问 ）
	 * 
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMyMsgList")
	public BaseResult getMyMsgList(String userId) {
		return new BaseResult().success(messageService.getMsgList(userId));
	}

}
