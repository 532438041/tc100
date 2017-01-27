package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.enums.LogTypeEnum;
import com.java.entity.Active;
import com.java.entity.ActiveItem;
import com.java.entity.ActiveLog;
import com.java.service.ActiveItemService;
import com.java.service.ActiveLogService;
import com.java.service.ActiveService;
import com.java.utils.ToolsUtil;

@RestController
public class ActiveController {

	@Autowired
	private ActiveService activeService;

	@Autowired
	private ActiveItemService activeItemService;

	@Autowired
	private ActiveLogService activeLogService;

	/**
	 * 根据参数获取已发布的活动列表 如 actType = A1 为首页轮播 pageSize = 5 取五条数据 若userId不为空 则为获取我的推广中已发布的活动列表
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActiveList")
	public BaseResult getActiveList(@RequestBody PageParam<Active> pageParam) {
		return new BaseResult().success(activeService.getActiveList(pageParam));
	}

	/**
	 * 获取我的模板 我的活动列表
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getMyActList")
	public BaseResult getMyActList(String userId, String actType) {
		return new BaseResult().success(activeService.getMyActList(userId, actType));
	}

	/**
	 * 获取同城购详情
	 * 
	 * @param @param actId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActive")
	public BaseResult getActive(String actId) {
		return new BaseResult().success(activeService.selectByPrimaryKey(actId));
	}

	/**
	 * 保存活动商品
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveItem")
	public BaseResult saveItem(@RequestBody BaseParam<ActiveItem> baseParam) {
		baseParam.getParam().setUpdateTime(new Date());
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setCreateTime(new Date());
			return new BaseResult().success(activeItemService.insert(baseParam.getParam()));
		} else {
			return new BaseResult().success(activeItemService.updateByPrimaryKeySelective(baseParam.getParam()));
		}
	}

	/**
	 * 获取单个商品信息
	 * 
	 * @param @param itemId
	 * @param @param actId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getItem")
	public BaseResult getItem(String itemId) {
		return new BaseResult().success(activeItemService.selectByPrimaryKey(itemId));
	}

	/**
	 * 获取活动下所有商品 按分类分开
	 * 
	 * @param @param actId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActItem")
	public BaseResult getActItem(String actId) {
		return null;
	}

	/**
	 * 点击详情 记录浏览记录
	 * 
	 * @param @param actId
	 * @param @param userId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/addViewCount")
	public BaseResult addViewCount(String actId, String userId) {
		// 判断该用户是否已浏览过 不重复记录
		int isLoged = activeLogService.isLoged(actId, userId, LogTypeEnum.LIULAN.getType());
		if (isLoged <= 0) {
			activeService.addViewCount(actId);
			// 记录操作日志
			addActLog(actId, userId, null, LogTypeEnum.LIULAN.getType());
			return new BaseResult().success();
		} else {
			return new BaseResult().success(-1, "请勿重复操作！");
		}
	}

	/**
	 * 同城购操作 关注 分享 重复 水贴 推送 推广 fromActId 不为空时 为推送操作
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/operateAct")
	public BaseResult operateAct(String actId, String fromActId, String userId, String logType) {
		if (ToolsUtil.isNotNull(fromActId)) {
			// fromActId 不为空时 为推送操作 新增一条

		} else {
			// 修改竞价排名资金

			// 记录操作日志

		}
		return null;
	}

	/**
	 * 添加act操作日志
	 * 
	 * @param @param actId
	 * @param @param userId
	 * @param @param logType
	 * @return void
	 */
	private void addActLog(String actId, String fromActId, String userId, String logType) {
		ActiveLog activeLog = new ActiveLog();
		activeLog.setId(ToolsUtil.getUUID());
		activeLog.setActId(actId);
		activeLog.setContent(LogTypeEnum.getMsgByType(logType));
		activeLog.setCreateTime(new Date());
		activeLog.setLogType(logType);
		activeLog.setUserId(userId);
		activeLogService.insert(activeLog);
	}

}
