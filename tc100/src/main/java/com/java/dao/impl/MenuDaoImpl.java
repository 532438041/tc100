package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.MenuDao;
import com.java.entity.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu>implements MenuDao {

	@Override
	public List<Menu> getMenuTree(String userId) {
		return this.getSqlSession().selectList(getStateMentName("getMenuTree"), userId);
	}

	@Override
	public List<Menu> getMenuList() {
		return this.getSqlSession().selectList(getStateMentName("getMenuList"));
	}

	@Override
	public List<Menu> getMenuByPid(Menu menu) {
		return this.getSqlSession().selectList(getStateMentName("getMenuByPid"), menu);
	}

}
