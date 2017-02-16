package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.OperateFee;
import com.java.service.OperateFeeService;
import com.java.utils.ToolsUtil;

@RestController
public class OperateFeeController {

	@Autowired
	private OperateFeeService operateFeeService;

	@RequestMapping(value = "/getOpFeeList")
	public BaseResult getOpFeeList(@RequestBody PageParam<OperateFee> pageParam) {
		return new BaseResult().success(operateFeeService.getOpFeeList(pageParam));
	}

	@RequestMapping(value = "/saveOpFee")
	public BaseResult saveOpFee(@RequestBody BaseParam<OperateFee> baseParam) {
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			return new BaseResult().success(operateFeeService.insert(baseParam.getParam()));
		} else {
			return new BaseResult().success(operateFeeService.updateByPrimaryKey(baseParam.getParam()));
		}
	}

	@RequestMapping(value = "/delOpFee")
	public BaseResult delOpFee(String id) {
		return new BaseResult().success(operateFeeService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/getOpFee")
	public BaseResult getOpFee(String id) {
		return new BaseResult().success(operateFeeService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/getOpFeeBy")
	public BaseResult getOpFeeBy(String logType) {
		return new BaseResult().success(operateFeeService.getOpFeeBy(logType));
	}

}
