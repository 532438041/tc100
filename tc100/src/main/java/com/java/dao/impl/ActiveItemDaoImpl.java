package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveItemDao;
import com.java.entity.ActiveItem;

@Repository
public class ActiveItemDaoImpl extends BaseDaoImpl<ActiveItem>implements ActiveItemDao {

	@Override
	public List<ActiveItem> getItemList(String cateId) {
		return this.getSqlSession().selectList(getStateMentName("getItemList"), cateId);
	}

}