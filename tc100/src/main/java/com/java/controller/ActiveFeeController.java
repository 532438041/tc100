package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.ActiveFee;
import com.java.service.ActiveFeeService;
import com.java.utils.ToolsUtil;

@RestController
public class ActiveFeeController {

	@Autowired
	private ActiveFeeService activeFeeService;

	@RequestMapping(value = "/getActFeeList")
	public BaseResult getActFeeList(@RequestBody PageParam<ActiveFee> pageParam) {
		return new BaseResult().success(activeFeeService.getActFeeList(pageParam));
	}

	@RequestMapping(value = "/saveActFee")
	public BaseResult saveActFee(@RequestBody BaseParam<ActiveFee> baseParam) {
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			return new BaseResult().success(activeFeeService.insert(baseParam.getParam()));
		} else {
			return new BaseResult().success(activeFeeService.updateByPrimaryKey(baseParam.getParam()));
		}
	}

	@RequestMapping(value = "/delActFee")
	public BaseResult delActFee(String id) {
		return new BaseResult().success(activeFeeService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/getActFee")
	public BaseResult getActFee(String id) {
		return new BaseResult().success(activeFeeService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/getActFeeBy")
	public BaseResult getActFeeBy(String actType) {
		return new BaseResult().success(activeFeeService.getActFeeBy(actType));
	}

}
