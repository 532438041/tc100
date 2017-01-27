package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.ActiveDao;
import com.java.entity.Active;
import com.java.service.ActiveService;
import com.java.utils.PageUtil;

@Service
public class ActiveServiceImpl extends BaseServiceImpl<Active>implements ActiveService {

	@Autowired
	private ActiveDao activeDao;

	@Override
	public PageResult<Active> getActiveList(PageParam<Active> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(activeDao.getActiveList(pageParam.getReqParam()));
	}

	@Override
	public List<Active> getMyActList(String userId, String actType) {
		return activeDao.getMyActList(userId, actType);
	}

	@Override
	public int addViewCount(String actId) {
		return activeDao.addViewCount(actId);
	}

}