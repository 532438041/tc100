package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Menu;

public interface MenuDao extends BaseDao<Menu> {

	List<Menu> getMenuTree(String userId);

	List<Menu> getMenuList();

	List<Menu> getMenuByPid(Menu menu);

}