package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.User;

public interface UserService extends BaseService<User>{

	User checkLogin(String userName);

	PageResult<User> getUserList(PageParam<User> pageParam);

	String getUserRoleName(String userId);

	int checkRegister(User user);

	String getUserIdByMobile(String mobile);

	int changePwd(String userName, String userPwd);

	List<User> getUserList();
	
}
