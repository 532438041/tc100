package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.CategoryDao;
import com.java.entity.Category;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category>implements CategoryDao {
	@Override
	public List<Category> getCategoryList() {
		return this.getSqlSession().selectList(getStateMentName("getCategoryList"));
	}
	
	@Override
	public List<Category> getCategoryOnceList() {
		return this.getSqlSession().selectList(getStateMentName("getCategoryOnceList"));
	}

	@Override
	public List<Category> getCateByPid(Category reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getCateByPid"), reqParam);
	}
}
