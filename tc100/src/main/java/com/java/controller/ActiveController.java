package com.java.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.java.entity.ItemCate;
import com.java.entity.OperateFee;
import com.java.entity.PayCode;
import com.java.entity.PayLog;
import com.java.entity.UserFav;
import com.java.service.ActiveItemService;
import com.java.service.ActiveLogService;
import com.java.service.ActiveService;
import com.java.service.ItemCateService;
import com.java.service.OperateFeeService;
import com.java.service.PayCodeService;
import com.java.service.PayLogService;
import com.java.service.UserFavService;
import com.java.utils.ToolsUtil;

@RestController
public class ActiveController {

	@Autowired
	private ActiveService activeService;

	@Autowired
	private ActiveItemService activeItemService;

	@Autowired
	private ActiveLogService activeLogService;

	@Autowired
	private UserFavService userFavService;

	@Autowired
	private ItemCateService itemCateService;

	@Autowired
	private OperateFeeService operateFeeService;

	@Autowired
	private PayCodeService payCodeService;

	@Autowired
	private PayLogService payLogService;

	/**
	 * 根据参数获取已发布的活动列表 如 actType = A1 为首页轮播 pageSize = 5 取五条数据 若userId不为空 则为获取我的推广中已发布的活动列表
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActiveList")
	public BaseResult getActiveList(@RequestBody PageParam<Active> pageParam) {
		if (ToolsUtil.isNull(pageParam.getReqParam().getState())) {
			pageParam.getReqParam().setState("2");
		}
		return new BaseResult().success(activeService.getActiveList(pageParam));
	}

	/**
	 * 获取个数 传参actType=A1 若多个 则用actType C1,C2,D1,D2 state 若不传值 为查询未发布和发布的
	 * 
	 * @param @param userId
	 * @param @param actType
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActCount")
	public BaseResult getActCount(String userId, String actType, String state) {
		return new BaseResult().success(activeService.getActCount(userId, actType, state));
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
	 * 添加活动
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveAct")
	public BaseResult saveActive(@RequestBody BaseParam<Active> baseParam) {
		baseParam.getParam().setUpdateTime(new Date());
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			// 添加
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setCreateTime(new Date());
			baseParam.getParam().setState("1"); // 未发布
			BaseResult baseResult = new BaseResult();
			baseResult.setStatus(activeService.insertSelective(baseParam.getParam()));
			baseResult.setData(baseParam.getParam().getId());
			return baseResult;
		} else {
			// 编辑
			return new BaseResult().success(activeService.updateByPrimaryKeySelective(baseParam.getParam()));
		}
	}

	/**
	 * 活动内容补充 活动发布
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/publicAct")
	public BaseResult publicAct(@RequestBody BaseParam<Active> baseParam) {
		if (ToolsUtil.isNotNull(baseParam.getParam().getPayCodeId())) {
			PayCode payCode = new PayCode();
			payCode.setId(baseParam.getParam().getPayCodeId());
			payCode.setActId(baseParam.getParam().getId());
			payCode.setState("2");
			payCodeService.updateByPrimaryKeySelective(payCode);
		} else if (!baseParam.getParam().getAmount().equals(BigDecimal.ZERO)) {
			// 保存支付记录
			PayLog payLog = new PayLog();
			payLog.setActId(baseParam.getParam().getId());
			payLog.setAmount(baseParam.getParam().getAmount());
			payLog.setCreateTime(new Date());
			payLog.setId(ToolsUtil.getUUID());
			payLog.setRemark("发布缴费");
			payLog.setUserId(baseParam.getParam().getUserId());
			payLogService.insert(payLog);
		}
		baseParam.getParam().setUpdateTime(new Date());
		baseParam.getParam().setState("2"); // 发布
		return new BaseResult().success(activeService.updateByPrimaryKeySelective(baseParam.getParam()), "");
	}

	/**
	 * 保存商品分类信息 返回分类id
	 * 
	 * @param @param baseParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/saveItemCate")
	public BaseResult saveItemCate(ItemCate itemCate) {
		itemCate.setUpdateTime(new Date());
		if (ToolsUtil.isNull(itemCate.getId())) {
			itemCate.setId(ToolsUtil.getUUID());
			itemCate.setCreateTime(new Date());
			itemCateService.insert(itemCate);
		} else {
			itemCateService.updateByPrimaryKeySelective(itemCate);
		}
		return new BaseResult().success(itemCate.getId());
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

	@RequestMapping(value = "/delItem")
	public BaseResult delItem(String itemId) {
		return new BaseResult().success(activeItemService.deleteByPrimaryKey(itemId));
	}

	/**
	 * 获取活动下所有商品 按分类分开
	 * 
	 * @param @param actId
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActItem")
	public BaseResult getActItem(String actId, String cateId, String limit) {
		// 获取分类
		List<ItemCate> cateList = itemCateService.getItemCateList(actId, cateId);
		Active active = activeService.selectByPrimaryKey(actId);
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		Integer temp = 0;
		if (ToolsUtil.isNotNull(limit)) {
			temp = Integer.parseInt(limit);
		}
		for (ItemCate itemCate : cateList) {
			List<ActiveItem> itemList = activeItemService.getItemList(itemCate.getId(), temp);
			Map<String, Object> map = new HashMap<>();
			map.put("cateId", itemCate.getId());
			map.put("cateName", itemCate.getCateName());
			map.put("active", active);
			map.put("itemList", itemList);
			resultList.add(map);
		}
		return new BaseResult().success(resultList);
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
			addActLog(actId, null, userId, LogTypeEnum.LIULAN.getType());
			return new BaseResult().success();
		} else {
			return new BaseResult().success(-1, "请勿重复操作！");
		}
	}

	/**
	 * 同城购操作 关注 分享 重复 水贴 推送 推广 取消关注 fromActId 不为空时 为推送操作
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/operateAct")
	public BaseResult operateAct(String actId, String fromActId, String userId, String fromUserId, String logType, String favId) {
		if (ToolsUtil.isNotNull(fromActId) && logType.equals("5")) {
			// fromActId 不为空时 为5推送操作 新增一条
			Active active = activeService.selectByPrimaryKey(fromActId);
			active.setId(ToolsUtil.getUUID());
			active.setCreateTime(new Date());
			active.setState("1"); // 未发布
			active.setViewCount(0);
			activeService.insert(active);
			actId = active.getId();
			userId = fromUserId;
		} else {
			// 判断该用户是否操作过 不重复记录
			int canOperate = activeLogService.isLoged(actId, userId, logType);
			if (!("1,6,7").contains(logType) && canOperate > 0) {
				return new BaseResult().failed(0, "该用户已操作过，请勿重复操作");
			}
			OperateFee operateFee = operateFeeService.getOpFeeBy(logType);
			if (logType.equals("1")) {
				// 1关注
				// 如果取消的次数跟关注次数不一样 说明当前已关注 不可重新关注
				int cishu = activeLogService.isLoged(actId, userId, "7");
				if (canOperate != cishu) {
					return new BaseResult().failed(0, "该用户已操作过，请勿重复操作");
				}
				UserFav userFav = new UserFav();
				userFav.setId(ToolsUtil.getUUID());
				userFav.setCreateTime(new Date());
				userFav.setActId(actId);
				userFav.setUserId(userId);
				userFavService.insert(userFav);
			} else if (logType.equals("2")) {
				// 2分享
				int isLoged = activeLogService.isLoged(actId, null, "2");
				if (isLoged >= 10) {
					return new BaseResult().failed(0, "分享金额已封顶");
				}
				activeService.operateAct(actId, operateFee.getAmount());
			} else if (logType.equals("3")) {
				// 3重复
				int isLoged = activeLogService.isLoged(actId, null, "3");
				if (isLoged >= 20) {
					return new BaseResult().failed(0, "重复次数已封顶");
				} else if (isLoged == 19) {
					// 帖子下架
					Active active = new Active();
					active.setId(actId);
					active.setUpdateTime(new Date());
					active.setState("1");
					activeService.updateByPrimaryKeySelective(active);
				}
				activeService.operateAct(actId, operateFee.getAmount());
			} else if (logType.equals("4")) {
				// 4水贴
				activeService.operateAct(actId, operateFee.getAmount());
			} else if (logType.equals("6")) {
				// 6推广

			} else if (logType.equals("7")) {
				// 7取消关注
				// 如果取消的次数跟关注次数一样 说明当前已取消 可重新关注 不可重复取消
				int cishu = activeLogService.isLoged(actId, userId, "1");
				if (canOperate == cishu) {
					return new BaseResult().failed(0, "该用户已操作过，请勿重复操作");
				}
				userFavService.deleteByPrimaryKey(favId);
			}
		}
		// 记录操作日志
		addActLog(actId, fromActId, userId, logType);
		return new BaseResult().success();
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
		activeLog.setFromActId(fromActId);
		activeLog.setContent(LogTypeEnum.getMsgByType(logType));
		activeLog.setCreateTime(new Date());
		activeLog.setLogType(logType);
		activeLog.setUserId(userId);
		activeLogService.insert(activeLog);
	}

	@RequestMapping(value = "/getActRegion")
	public BaseResult getActRegion(String addName, String actType) {
		return new BaseResult().success(activeService.getActRegion(addName, actType));
	}

	/**
	 * 后台模板列表
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActList")
	public BaseResult getActList(@RequestBody PageParam<Active> pageParam) {
		return new BaseResult().success(activeService.getActList(pageParam));
	}

	@RequestMapping(value = "/delAct")
	public BaseResult delAct(String actId) {
		Active active = new Active();
		active.setId(actId);
		active.setUpdateTime(new Date());
		active.setState("0");
		return new BaseResult().success(activeService.updateByPrimaryKeySelective(active));
	}

}
