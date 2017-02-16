package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.OperateFeeDao;
import com.java.entity.OperateFee;

@Repository
public class OperateFeeDaoImpl extends BaseDaoImpl<OperateFee>implements OperateFeeDao {

	@Override
	public List<OperateFee> getOpFeeList(OperateFee reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getOpFeeList"), reqParam);
	}

	@Override
	public OperateFee getOpFeeBy(String logType) {
		return this.getSqlSession().selectOne(getStateMentName("getOpFeeBy"), logType);
	}

}