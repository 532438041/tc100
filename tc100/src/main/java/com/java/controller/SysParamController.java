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

@RestController
public class SysParamController {

	@Autowired
	private SysParamService sysParamService;

	@RequestMapping(value = "/getSysPList")
	public BaseResult getSysPList(@RequestBody PageParam<SysParam> pageParam) {
		return null;
	}

	@RequestMapping(value = "/saveSysP")
	public BaseResult saveSysP(@RequestBody BaseParam<SysParam> baseParam) {
		return null;
	}

	public BaseResult delSysP(String id) {
		return new BaseResult().success(sysParamService.deleteByPrimaryKey(id));
	}

	public BaseResult getSysPByKey() {
		return null;
	}

}
