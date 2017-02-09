package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.ActiveItemDao;
import com.java.entity.ActiveItem;
import com.java.service.ActiveItemService;

@Service
public class ActiveItemServiceImpl extends BaseServiceImpl<ActiveItem>implements ActiveItemService {

	@Autowired
	private ActiveItemDao activeItemDao;

	@Override
	public List<ActiveItem> getItemList(String cateId, int limit) {
		return activeItemDao.getItemList(cateId, limit);
	}

}