package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Category;

public interface CategoryService extends BaseService<Category>{

	PageResult<Category> getCategoryList(PageParam<Category> pageParam);
	
	PageResult<Category> getCategoryOnceList(PageParam<Category> pageParam);

	List<Category> getCategoryList();

	PageResult<Category> getCateByPid(PageParam<Category> pageParam);
	
}
