package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveItemDao;
import com.java.entity.ActiveItem;

@Repository
public class ActiveItemDaoImpl extends BaseDaoImpl<ActiveItem>implements ActiveItemDao {

	@Override
	public List<ActiveItem> getItemList(String cateId, int limit) {
		Map<String, Object> map = new HashMap<>();
		map.put("cateId", cateId);
		map.put("limit", limit);
		return this.getSqlSession().selectList(getStateMentName("getItemList"), map);
	}

}