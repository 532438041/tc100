package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.ActiveFeeDao;
import com.java.entity.ActiveFee;
import com.java.service.ActiveFeeService;
import com.java.utils.PageUtil;

@Service
public class ActiveFeeServiceImpl extends BaseServiceImpl<ActiveFee>implements ActiveFeeService {

	@Autowired
	private ActiveFeeDao activeFeeDao;

	@Override
	public PageResult<ActiveFee> getActFeeList(PageParam<ActiveFee> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(activeFeeDao.getActFeeList(pageParam.getReqParam()));
	}

	@Override
	public ActiveFee getActFeeBy(String actType) {
		return activeFeeDao.getActFeeBy(actType);
	}

}