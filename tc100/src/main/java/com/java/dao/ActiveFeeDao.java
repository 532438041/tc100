package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.ActiveFee;

public interface ActiveFeeDao extends BaseDao<ActiveFee> {

	List<ActiveFee> getActFeeList(ActiveFee activeFee);

	ActiveFee getActFeeBy(String actType);

}