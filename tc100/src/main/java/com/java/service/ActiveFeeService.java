package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.ActiveFee;

public interface ActiveFeeService extends BaseService<ActiveFee> {

	PageResult<ActiveFee> getActFeeList(PageParam<ActiveFee> pageParam);

	ActiveFee getActFeeBy(String actType);

}