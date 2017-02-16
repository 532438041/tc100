package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.SysParamDao;
import com.java.entity.SysParam;
import com.java.service.SysParamService;
import com.java.utils.PageUtil;

@Service
public class SysParamServiceImpl extends BaseServiceImpl<SysParam>implements SysParamService {

	@Autowired
	private SysParamDao sysParamDao;

	@Override
	public PageResult<SysParam> getSysPList(PageParam<SysParam> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(sysParamDao.getSysPList(pageParam.getReqParam()));
	}

	@Override
	public SysParam getSysPByPKey(String pKey) {
		return sysParamDao.getSysPByPKey(pKey);
	}

}