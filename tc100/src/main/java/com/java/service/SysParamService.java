package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {

	PageResult<SysParam> getSysPList(PageParam<SysParam> pageParam);

	SysParam getSysPByPKey(String pKey);

}