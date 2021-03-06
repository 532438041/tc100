package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.PayLogDao;
import com.java.entity.PayLog;
import com.java.service.PayLogService;
import com.java.utils.PageUtil;

@Service
public class PayLogServiceImpl extends BaseServiceImpl<PayLog>implements PayLogService {

	@Autowired
	private PayLogDao payLogDao;

	@Override
	public PageResult<PayLog> getPayLogList(PageParam<PayLog> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(payLogDao.getPayLogList(pageParam.getReqParam()));
	}

}