package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.PageUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<User>implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User checkLogin(String userName) {
		return userDao.checkLogin(userName);
	}

	@Override
	public PageResult<User> getUserList(PageParam<User> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(userDao.getUserList(pageParam.getReqParam()));
	}

	@Override
	public String getUserRoleName(String userId) {
		return userDao.getUserRoleName(userId);
	}

	@Override
	public int checkRegister(User user) {
		return userDao.checkRegister(user);
	}

}
