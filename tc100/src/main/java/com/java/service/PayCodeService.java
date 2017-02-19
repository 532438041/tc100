package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.entity.PayCode;

public interface PayCodeService extends BaseService<PayCode>{

	List<PayCode> getPayCodeList(String payCode);
    
}