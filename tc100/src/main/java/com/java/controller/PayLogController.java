package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.PayLog;
import com.java.service.PayLogService;
import com.java.utils.ToolsUtil;

@RestController
public class PayLogController {

	@Autowired
	private PayLogService payLogService;

	@RequestMapping(value = "/getPayLogList")
	public BaseResult getPayLogList(@RequestBody PageParam<PayLog> pageParam) {
		return new BaseResult().success(payLogService.getPayLogList(pageParam));
	}

	@RequestMapping(value = "/savePayLog")
	public BaseResult savePayLog(@RequestBody BaseParam<PayLog> baseParam) {
		baseParam.getParam().setId(ToolsUtil.getUUID());
		baseParam.getParam().setCreateTime(new Date());
		return new BaseResult().success(payLogService.insert(baseParam.getParam()));
	}

}
