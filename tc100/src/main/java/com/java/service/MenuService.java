package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Menu;

public interface MenuService extends BaseService<Menu> {

	List<Menu> getMenuTree(String userId);

	List<Menu> getMenuList();

	PageResult<Menu> getMenuByPid(PageParam<Menu> pageParam);

}
