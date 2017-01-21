package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Active;
import com.java.service.ActiveService;

@RestController
public class ActiveController {

	@Autowired
	private ActiveService activeService;

	/**
	 * 根据参数获取活动列表 如 actType = A1 为首页轮播 pageSize = 5 取五条数据
	 * 
	 * @param @param pageParam
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getActiveList")
	public BaseResult getActiveList(@RequestBody PageParam<Active> pageParam) {
		return new BaseResult().success(activeService.getActiveList(pageParam));
	}

}
