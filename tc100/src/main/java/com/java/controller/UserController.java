package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.entity.UserCard;
import com.java.service.UserCardService;
import com.java.service.UserFavService;
import com.java.utils.ToolsUtil;

@RestController
public class UserController {

	@Autowired
	private UserCardService userCardService;

	@Autowired
	private UserFavService userFavService;

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

}
