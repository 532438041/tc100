package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.SysParamDao;
import com.java.entity.SysParam;

@Repository
public class SysParamDaoImpl extends BaseDaoImpl<SysParam>implements SysParamDao {

	@Override
	public List<SysParam> getSysPList(SysParam reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getSysPList"), reqParam);
	}

	@Override
	public SysParam getSysPByPKey(String pKey) {
		return this.getSqlSession().selectOne(getStateMentName("getSysPByPKey"), pKey);
	}

}