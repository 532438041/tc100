package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ActiveFeeDao;
import com.java.entity.ActiveFee;

@Repository
public class ActiveFeeDaoImpl extends BaseDaoImpl<ActiveFee>implements ActiveFeeDao {

	@Override
	public List<ActiveFee> getActFeeList(ActiveFee activeFee) {
		return this.getSqlSession().selectList(getStateMentName("getActFeeList"), activeFee);
	}

	@Override
	public ActiveFee getActFeeBy(String actType) {
		return this.getSqlSession().selectOne(getStateMentName("getActFeeBy"), actType);
	}

}