package com.java.service;

import com.java.base.BaseService;
import com.java.entity.ActiveLog;

public interface ActiveLogService extends BaseService<ActiveLog> {

	int isLoged(String actId, String userId, String logType);
  
}