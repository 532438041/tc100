package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.entity.ItemCate;

public interface ItemCateService extends BaseService<ItemCate>{

	List<ItemCate> getItemCateList(String actId, String cateId);

}