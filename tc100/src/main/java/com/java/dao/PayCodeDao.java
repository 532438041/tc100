package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.PayCode;

public interface PayCodeDao extends BaseDao<PayCode>{

	List<PayCode> getPayCodeList(String payCode);
    
}