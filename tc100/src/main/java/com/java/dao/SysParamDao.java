package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.SysParam;

public interface SysParamDao extends BaseDao<SysParam> {

	List<SysParam> getSysPList(SysParam reqParam);

	SysParam getSysPByPKey(String pKey);

}