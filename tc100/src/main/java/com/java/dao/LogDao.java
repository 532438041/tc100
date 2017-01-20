package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.LogDto;
import com.java.entity.Log;

public interface LogDao extends BaseDao<Log> {

	List<LogDto> getLogList(Log log);
}