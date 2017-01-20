package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dto.LogDto;
import com.java.entity.Log;

public interface LogService extends BaseService<Log> {

	PageResult<LogDto> getLogList(PageParam<Log> pageParam);

}
