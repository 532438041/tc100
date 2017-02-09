package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ItemCateDao;
import com.java.entity.ItemCate;

@Repository
public class ItemCateDaoImpl extends BaseDaoImpl<ItemCate>implements ItemCateDao {

	@Override
	public List<ItemCate> getItemCateList(String actId, String cateId) {
		Map<String, String> map = new HashMap<>();
		map.put("actId", actId);
		map.put("cateId", cateId);
		return this.getSqlSession().selectList(getStateMentName("getItemCateList"), map);
	}

}