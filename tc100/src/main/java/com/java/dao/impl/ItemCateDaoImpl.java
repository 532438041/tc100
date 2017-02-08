package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ItemCateDao;
import com.java.entity.ItemCate;

@Repository
public class ItemCateDaoImpl extends BaseDaoImpl<ItemCate>implements ItemCateDao {

	@Override
	public List<ItemCate> getItemCateList(String actId) {
		return this.getSqlSession().selectList(getStateMentName("getItemCateList"), actId);
	}

}