package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.entity.ActiveItem;

public interface ActiveItemService extends BaseService<ActiveItem>{

	List<ActiveItem> getItemList(String cateId);
  
}