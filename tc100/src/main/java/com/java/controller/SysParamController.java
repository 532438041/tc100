package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.SysParam;
import com.java.service.SysParamService;
import com.java.utils.ToolsUtil;

@RestController
public class SysParamController {

	@Autowired
	private SysParamService sysParamService;

	@RequestMapping(value = "/getSysPList")
	public BaseResult getSysPList(@RequestBody PageParam<SysParam> pageParam) {
		return new BaseResult().success(sysParamService.getSysPList(pageParam));
	}

	@RequestMapping(value = "/saveSysP")
	public BaseResult saveSysP(@RequestBody BaseParam<SysParam> baseParam) {
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			return new BaseResult().success(sysParamService.insert(baseParam.getParam()));
		} else {
			return new BaseResult().success(sysParamService.updateByPrimaryKey(baseParam.getParam()));
		}
	}

	@RequestMapping(value = "/delSysP")
	public BaseResult delSysP(String id) {
		return new BaseResult().success(sysParamService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/getSysP")
	public BaseResult getSysP(String id) {
		return new BaseResult().success(sysParamService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/getSysPByKey")
	public BaseResult getSysPByPKey(String pKey) {
		return new BaseResult().success(sysParamService.getSysPByPKey(pKey));
	}

}
