package com.java.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.annotation.SysLog;
import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	@SysLog(operationType = "select", operationName = "前台用户登录")
	public BaseResult login(@RequestBody BaseParam<User> baseParam, HttpServletResponse response) {
		User user = userService.checkLogin(baseParam.getParam().getUserName());
		BaseResult baseResult = new BaseResult();
		if (ToolsUtil.isNotNull(user)) {
			if (!user.getUserType().equals("1")) {
				return baseResult.failed(-2, "该用户不能登录本站点！");
			}
			if (user.getState().equals("2")) {
				return baseResult.failed(-3, "该用户已被禁用，请联系管理员！");
			}
			if (user.getState().equals("0")) {
				return baseResult.failed(-4, "用户名不存在！");
			}
			if (!ToolsUtil.MD5(user.getId() + baseParam.getParam().getUserPwd()).equals(user.getUserPwd())) {
				// 记录密码错误次数

				return baseResult.failed(-1, "用户名或密码错误！");
			}
		} else {
			return baseResult.failed(0, "用户名不存在！");
		}

		// 记录登录状态

		// 保存登录信息
		ToolsUtil.setCookie(response, "userId", user.getId());
		ToolsUtil.setCookie(response, "displayName", user.getDisplayName());

		return baseResult.success(1, "登录成功！");
	}

	@RequestMapping(value = "/register")
	@SysLog(operationType = "insert", operationName = "前台用户登录")
	public BaseResult register(@RequestBody BaseParam<User> baseParam) {
		BaseResult baseResult = new BaseResult();
		int status = 0;
		// 查重校验
		status = userService.checkRegister(baseParam.getParam());
		if (status > 0) {
			return baseResult.failed(2, "该手机号/邮箱已注册！");
		}
		baseParam.getParam().setId(ToolsUtil.getUUID());
		baseParam.getParam().setUserPwd(ToolsUtil.MD5(baseParam.getParam().getId() + baseParam.getParam().getUserPwd()));
		baseParam.getParam().setCreateBy(baseParam.getParam().getId());
		baseParam.getParam().setCreateTime(new Date());
		baseParam.getParam().setState("1");
		baseParam.getParam().setUserType("1");
		status = userService.insert(baseParam.getParam());
		baseResult.setStatus(status);
		baseResult.setMsg(status > 0 ? "注册成功！" : "注册失败！");
		return baseResult;
	}

	@RequestMapping(value = "/logout")
	@SysLog(operationType = "select", operationName = "前台用户退出")
	public BaseResult logout(String userId, String displayName, HttpServletResponse response) {
		ToolsUtil.removeCookie(response, "userId");
		ToolsUtil.removeCookie(response, "displayName");
		return new BaseResult().success();
	}

	@RequestMapping(value = "/test")
	public BaseResult test() {
		return new BaseResult().success();
	}

}
