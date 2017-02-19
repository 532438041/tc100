package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.PayCodeDao;
import com.java.entity.PayCode;

@Repository
public class PayCodeDaoImpl extends BaseDaoImpl<PayCode>implements PayCodeDao {

	@Override
	public List<PayCode> getPayCodeList(String payCode) {
		return this.getSqlSession().selectList(getStateMentName("getPayCodeList"), payCode);
	}

}