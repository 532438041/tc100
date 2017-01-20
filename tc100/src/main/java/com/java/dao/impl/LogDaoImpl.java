package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.LogDao;
import com.java.dto.LogDto;
import com.java.entity.Log;

@Repository
public class LogDaoImpl extends BaseDaoImpl<Log>implements LogDao {

	@Override
	public List<LogDto> getLogList(Log log) {
		return this.getSqlSession().selectList(getStateMentName("getLogList"), log);
	}

}
