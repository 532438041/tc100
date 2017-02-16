package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.OperateFee;

public interface OperateFeeDao extends BaseDao<OperateFee> {

	List<OperateFee> getOpFeeList(OperateFee reqParam);

	OperateFee getOpFeeBy(String logType);

}