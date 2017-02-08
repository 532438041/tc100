package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.ActiveItem;

public interface ActiveItemDao extends BaseDao<ActiveItem>{

	List<ActiveItem> getItemList(String cateId);
  
}