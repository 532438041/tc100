package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserDao;
import com.java.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User checkLogin(String userName) {
		return this.getSqlSession().selectOne(getStateMentName("checkLogin"), userName);
	}

	@Override
	public List<User> getUserList(User user) {
		return this.getSqlSession().selectList(getStateMentName("getUserList"), user);
	}

	@Override
	public String getUserRoleName(String userId) {
		return this.getSqlSession().selectOne("getUserRoleName", userId);
	}

	@Override
	public int checkRegister(User user) {
		return this.getSqlSession().selectOne(getStateMentName("checkRegister"), user);
	}

	@Override
	public String getUserIdByMobile(String mobile) {
		return this.getSqlSession().selectOne(getStateMentName("getUserIdByMobile"), mobile);
	}

	@Override
	public int changePwd(String userName, String userPwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		map.put("userPwd", userPwd);
		return this.getSqlSession().update(getStateMentName("changePwd"), map);
	}

	@Override
	public int changeDisplayName(String userName, String displayName) {
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		map.put("displayName", displayName);
		return this.getSqlSession().update(getStateMentName("changeDisplayName"), map);
	}

	@Override
	public int changePicUrl(String userName, String picUrl) {
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		map.put("picUrl", picUrl);
		return this.getSqlSession().update(getStateMentName("changePicUrl"), map);
	}

	@Override
	public int changeUesrState(String userId, String state) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("state", state);
		return this.getSqlSession().update(getStateMentName("changeUesrState"), map);
	}

}
