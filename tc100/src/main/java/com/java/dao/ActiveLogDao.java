package com.java.dao;

import com.java.base.BaseDao;
import com.java.entity.ActiveLog;

public interface ActiveLogDao extends BaseDao<ActiveLog> {

	int isLoged(String actId, String userId, String logType);
  
}