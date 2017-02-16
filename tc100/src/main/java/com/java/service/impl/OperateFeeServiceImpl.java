package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.OperateFeeDao;
import com.java.entity.OperateFee;
import com.java.service.OperateFeeService;
import com.java.utils.PageUtil;

@Service
public class OperateFeeServiceImpl extends BaseServiceImpl<OperateFee>implements OperateFeeService {

	@Autowired
	private OperateFeeDao operateFeeDao;

	@Override
	public PageResult<OperateFee> getOpFeeList(PageParam<OperateFee> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(operateFeeDao.getOpFeeList(pageParam.getReqParam()));
	}

	@Override
	public OperateFee getOpFeeBy(String logType) {
		return operateFeeDao.getOpFeeBy(logType);
	}

}