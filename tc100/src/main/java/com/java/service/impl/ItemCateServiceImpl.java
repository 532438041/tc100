package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.ItemCateDao;
import com.java.entity.ItemCate;
import com.java.service.ItemCateService;

@Service
public class ItemCateServiceImpl extends BaseServiceImpl<ItemCate>implements ItemCateService {

	@Autowired
	private ItemCateDao itemCateDao;

	@Override
	public List<ItemCate> getItemCateList(String actId, String cateId) {
		return itemCateDao.getItemCateList(actId, cateId);
	}

}