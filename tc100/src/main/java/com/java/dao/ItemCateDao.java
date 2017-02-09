package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.ItemCate;

public interface ItemCateDao extends BaseDao<ItemCate>{

	List<ItemCate> getItemCateList(String actId, String cateId);

}