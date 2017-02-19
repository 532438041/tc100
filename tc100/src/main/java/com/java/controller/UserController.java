package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.User;
import com.java.entity.UserCard;
import com.java.entity.UserMsg;
import com.java.service.UserCardService;
import com.java.service.UserFavService;
import com.java.service.UserMsgService;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCardService userCardService;

	@Autowired
	private UserFavService userFavService;

	@Autowired
	private UserMsgService userMsgService;

	/**
	 * 获取我的名片列表
	 * 
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getCardList")
	public BaseResult getCardList(String userId) {
		return new BaseResult().success(userCardService.getCardList(userId));
	}

	/**
	 * 获取我的名片
	 * 
	 * @param @param cardId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getCard")
	public BaseResult getCard(String cardId) {
		return new BaseResult().success(userCardService.selectByPrimaryKey(cardId));
	}

	/**
	 * 保存我的名片
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveCard")
	public BaseResult saveCard(@RequestBody BaseParam<UserCard> baseParam) {
		baseParam.getParam().setUpdateTime(new Date());
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setCreateTime(new Date());
			baseParam.getParam().setState("1");
			return new BaseResult().success(userCardService.insert(baseParam.getParam()));
		} else {
			return new BaseResult().success(userCardService.updateByPrimaryKeySelective(baseParam.getParam()));
		}
	}

	/**
	 * 删除我的名片
	 * 
	 * @param @param cardId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/delCard")
	public BaseResult delCard(String cardId) {
		UserCard userCard = new UserCard();
		userCard.setId(cardId);
		userCard.setState("0");
		return new BaseResult().success(userCardService.updateByPrimaryKeySelective(userCard));
	}

	/**
	 * 获取我的关注列表
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getFavList")
	public BaseResult getFavList(String userId) {
		return new BaseResult().success(userFavService.getFavList(userId));
	}

	/**
	 * 获取用户的消息个数 msgType 0系统消息 1活动消息 2推广消息 state 1未读 2已读 值为空是 为获取全部
	 * 
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMsgCount")
	public BaseResult getMsgCount(String userId, String msgType, String state) {
		BaseResult baseResult = new BaseResult();
		if (ToolsUtil.isNotNull(userId)) {
			return baseResult.success(userMsgService.getMsgCount(userId, msgType, state));
		}
		return baseResult.failed(0, "用户未登录！");
	}

	/**
	 * 获取用户的消息列表 msgType 0系统消息 1活动消息 2推广消息 state 1未读 2已读 值为空是 为获取全部
	 * 
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getUserMsgList")
	public BaseResult getUserMsgList(String userId, String msgType, String state) {
		return new BaseResult().success(userMsgService.getUserMsgList(userId, msgType, state));
	}

	/**
	 * 改变成已读
	 * 
	 * @param @param msgId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/changeUserMsgState")
	public BaseResult changeUserMsgState(String msgId) {
		UserMsg userMsg = new UserMsg();
		userMsg.setId(msgId);
		userMsg.setState("2");
		return new BaseResult().success(userMsgService.updateByPrimaryKey(userMsg));
	}

	/**
	 * 获取我的消息详情
	 * 
	 * @param @param msgId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getUserMsg")
	public BaseResult getUserMsg(String msgId) {
		return new BaseResult().success(userMsgService.selectByPrimaryKey(msgId));
	}

	/**
	 * 发送消息
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveUserMsg")
	public BaseResult saveUserMsg(@RequestBody BaseParam<UserMsg> baseParam) {
		baseParam.getParam().setId(ToolsUtil.getUUID());
		baseParam.getParam().setCreateTime(new Date());
		baseParam.getParam().setState("1");
		return new BaseResult().success(userMsgService.insert(baseParam.getParam()));
	}

	@RequestMapping(value = "/getReceiveAct")
	public BaseResult getReceiveAct(String userId) {
		return null;
	}

	@RequestMapping(value = "/getUserList")
	public BaseResult getUserList(@RequestBody PageParam<User> pageParam) {
		return new BaseResult().success(userService.getUserList(pageParam));
	}

	/**
	 * 根据手机号获取用户id 用于推送取用户
	 * 
	 * @param @param mobile
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getUserIdByMobile")
	public BaseResult getUserIdByMobile(String mobile) {
		return new BaseResult().success(userService.getUserIdByMobile(mobile));
	}

}
