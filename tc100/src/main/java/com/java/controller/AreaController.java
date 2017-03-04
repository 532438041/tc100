package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.service.AreaService;
import com.java.utils.ToolsUtil;

@RestController
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping("/getAreaByPid")
	public BaseResult getAreaByPid(String pid) {
		if (ToolsUtil.isNull(pid)) {
			pid = "0";
		}
		return new BaseResult().success(areaService.getAreaByPid(pid));
	}

	@RequestMapping("/getAreaByName")
	public BaseResult getAreaByName(String cityName) {
		return new BaseResult().success(areaService.getAreaByName(cityName));
	}

}
