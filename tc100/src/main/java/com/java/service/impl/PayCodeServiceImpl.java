package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.PayCodeDao;
import com.java.entity.PayCode;
import com.java.service.PayCodeService;

@Service
public class PayCodeServiceImpl extends BaseServiceImpl<PayCode>implements PayCodeService {

	@Autowired
	private PayCodeDao payCodeDao;

	@Override
	public List<PayCode> getPayCodeList(String payCode) {
		return payCodeDao.getPayCodeList(payCode);
	}

}