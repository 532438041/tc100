package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.PayLog;

public interface PayLogService extends BaseService<PayLog> {

	PageResult<PayLog> getPayLogList(PageParam<PayLog> pageParam);

}