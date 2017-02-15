package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.annotation.SysLog;
import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Menu;
import com.java.service.MenuService;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getMenuTree")
	public BaseResult getMenuTree(@CookieValue("userId") String userId) {
		String userRoleName = userService.getUserRoleName(userId);
		BaseResult baseResult = new BaseResult();
		if (userRoleName.contains("system")) {
			baseResult.setData(menuService.getMenuList());
		} else {
			baseResult.setData(menuService.getMenuTree(userId));
		}
		return baseResult.success();
	}

	@RequestMapping(value = "/getMenuByPid")
	public BaseResult getMenuByPid(@RequestBody PageParam<Menu> pageParam) {
		if (ToolsUtil.isNull(pageParam.getReqParam().getPid()))
			pageParam.getReqParam().setPid("0");
		BaseResult baseResult = new BaseResult();
		baseResult.setData(menuService.getMenuByPid(pageParam));
		return baseResult;
	}

	@RequestMapping(value = "/saveMenu")
	@SysLog(operationType = "add/update", operationName = "添加、编辑模块")
	public BaseResult saveMenu(@RequestBody BaseParam<Menu> baseParam, @CookieValue("userId") String userId) {
		baseParam.getParam().setUpdateBy(userId);
		baseParam.getParam().setUpdateTime(new Date());
		BaseResult baseResult = new BaseResult();
		int status = 0;
		if (ToolsUtil.isNotNull(baseParam.getParam().getId())) {
			// 编辑
			status = menuService.updateByPrimaryKeySelective(baseParam.getParam());
		} else {
			// 添加
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setState("1");
			baseParam.getParam().setCreateBy(userId);
			baseParam.getParam().setCreateTime(new Date());
			status = menuService.insert(baseParam.getParam());
		}
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/deleteMenu")
	@SysLog(operationType = "delete", operationName = "删除模块")
	public BaseResult deleteMenu(String menuId, @CookieValue("userId") String userId) {
		BaseResult baseResult = new BaseResult();
		Menu menu = new Menu();
		menu.setId(menuId);
		menu.setUpdateBy(userId);
		menu.setUpdateTime(new Date());
		menu.setState("0");
		int status = menuService.updateByPrimaryKeySelective(menu);
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/getMenuById")
	public BaseResult getMenuById(String menuId) {
		return new BaseResult().success(menuService.selectByPrimaryKey(menuId));
	}

}
