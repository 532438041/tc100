package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.MenuDao;
import com.java.entity.Menu;
import com.java.service.MenuService;
import com.java.utils.PageUtil;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu>implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getMenuTree(String userId) {
		return menuDao.getMenuTree(userId);
	}

	@Override
	public List<Menu> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public PageResult<Menu> getMenuByPid(PageParam<Menu> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(menuDao.getMenuByPid(pageParam.getReqParam()));
	}

}
