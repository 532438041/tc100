package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Active;

public interface ActiveService extends BaseService<Active> {

	/**
	 * 根据参数获取活动列表 如 actType = A1 为首页轮播 pageSize = 5 取五条数据
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return PageResult<Active>
	 */
	PageResult<Active> getActiveList(PageParam<Active> pageParam);

}