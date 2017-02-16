package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.OperateFee;

public interface OperateFeeService extends BaseService<OperateFee> {

	PageResult<OperateFee> getOpFeeList(PageParam<OperateFee> pageParam);

	OperateFee getOpFeeBy(String logType);

}