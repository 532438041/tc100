package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.ActiveLogDao;
import com.java.entity.ActiveLog;
import com.java.service.ActiveLogService;

@Service
public class ActiveLogServiceImpl extends BaseServiceImpl<ActiveLog>implements ActiveLogService {

	@Autowired
	private ActiveLogDao activeLogDao;

	@Override
	public int isLoged(String actId, String userId, String logType) {
		return activeLogDao.isLoged(actId, userId, logType);
	}

}