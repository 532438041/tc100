package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Category;

public interface CategoryDao extends BaseDao<Category> {
	
	public List<Category> getCategoryList();
	
	public List<Category> getCategoryOnceList();

	public List<Category> getCateByPid(Category reqParam);

}