package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.PayLog;

public interface PayLogDao extends BaseDao<PayLog>{

	List<PayLog> getPayLogList(PayLog reqParam);

}