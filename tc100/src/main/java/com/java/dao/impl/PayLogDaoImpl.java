package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.PayLogDao;
import com.java.entity.PayLog;

@Repository
public class PayLogDaoImpl extends BaseDaoImpl<PayLog>implements PayLogDao {

	@Override
	public List<PayLog> getPayLogList(PayLog reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getPayLogList"), reqParam);
	}

}