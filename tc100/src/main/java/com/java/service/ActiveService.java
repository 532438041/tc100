package com.java.service;

import java.math.BigDecimal;
import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Active;

public interface ActiveService extends BaseService<Active> {

	/**
	 * 根据参数获取已发布的活动列表 如 actType = A1 为首页轮播 pageSize = 5 取五条数据 若userId不为空 则为获取我的推广中已发布的活动列表
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return PageResult<Active>
	 */
	PageResult<Active> getActiveList(PageParam<Active> pageParam);

	/**
	 * 获取我的模板 我的活动列表
	 * 
	 * @param userId
	 * @param actType
	 * @param @return
	 * @return List<Active>
	 */
	List<Active> getMyActList(String userId, String actType);
	
	/**
	 * 验证用户名重复
	 * @param pageParam
	 * @return
	 */
	List<Active> checkActName(Active reqParam);

	int addViewCount(String actId);

	void operateAct(String actId, BigDecimal bigDecimal);
	
	List<Active> getActFBList(String userId, String actType, String state);

	List<String> getActRegion(String addName, String actType);

	PageResult<Active> getActList(PageParam<Active> pageParam);

	int upAct(Active active);

}