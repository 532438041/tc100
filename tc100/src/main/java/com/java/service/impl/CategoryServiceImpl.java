package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.CategoryDao;
import com.java.entity.Category;
import com.java.service.CategoryService;
import com.java.utils.PageUtil;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category>implements CategoryService {

	@Autowired
	private CategoryDao articleCateDao;

	@Override
	public PageResult<Category> getCategoryList(PageParam<Category> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleCateDao.getCategoryList());
	}
	
	/**
	 * 获取一级分类列表
	 */
	@Override
	public PageResult<Category> getCategoryOnceList(PageParam<Category> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleCateDao.getCategoryOnceList());
	}

	@Override
	public List<Category> getCategoryList() {
		return articleCateDao.getCategoryList();
	}

	@Override
	public PageResult<Category> getCateByPid(PageParam<Category> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleCateDao.getCateByPid(pageParam.getReqParam()));
	}
}
