package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.User;

public interface UserDao extends BaseDao<User>{

	User checkLogin(String userName);

	List<User> getUserList(User user);

	String getUserRoleName(String userId);

	int checkRegister(User user);

	String getUserIdByMobile(String mobile);

	int changePwd(String userName, String userPwd);

}