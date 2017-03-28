package com.java.service.impl;

import java.math.BigDecimal;
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
public class ActiveServiceImpl extends BaseServiceImpl<Active> implements ActiveService {

	@Autowired
	private ActiveDao activeDao;

	@Override
	public PageResult<Active> getActiveList(PageParam<Active> pageParam) {
		String orderBy = "";
		switch (pageParam.getReqParam().getOrderBy()) {
			case "amount":
				orderBy = "act.`amount` DESC";
				break;
			case "viewCount":
				orderBy = "act.`view_count` DESC";
				break;
			case "dateTime":
				orderBy = "act.`offlineEndTime` DESC";
				break;
			default:
				orderBy = " act.`act_type`, act.`amount` DESC";
				break;
		}
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderBy);
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

	@Override
	public void operateAct(String actId, BigDecimal amount) {
		activeDao.operateAct(actId, amount);
	}

	@Override
	public List<Active> getActFBList(String userId, String actType, String state) {
		return activeDao.getActFBList(userId, actType, state);
	}

	@Override
	public List<String> getActRegion(String addName, String actType) {
		return activeDao.getActRegion(addName, actType);
	}

	@Override
	public PageResult<Active> getActList(PageParam<Active> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(activeDao.getActList(pageParam.getReqParam()));
	}

	@Override
	public int upAct(Active active) {
		return activeDao.upAct(active);
	}

	@Override
	public List<Active> checkActName(Active reqParam) {
		return activeDao.checkActName(reqParam);
	}
	
}