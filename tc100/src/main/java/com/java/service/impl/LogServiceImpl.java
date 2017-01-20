package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.LogDao;
import com.java.dto.LogDto;
import com.java.entity.Log;
import com.java.service.LogService;
import com.java.utils.PageUtil;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log>implements LogService {

	@Autowired
	private LogDao logDao;

	@Override
	public PageResult<LogDto> getLogList(PageParam<Log> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(logDao.getLogList(pageParam.getReqParam()));
	}

}
