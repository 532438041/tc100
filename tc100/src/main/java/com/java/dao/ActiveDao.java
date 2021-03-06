package com.java.dao;

import java.math.BigDecimal;
import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Active;

public interface ActiveDao extends BaseDao<Active>{

	List<Active> getActiveList(Active reqParam);

	List<Active> getMyActList(String userId, String actType);

	int addViewCount(String actId);

	void operateAct(String actId, BigDecimal amount);

	List<Active> getActFBList(String userId, String actType, String state);

	List<String> getActRegion(String addName, String actType);

	List<Active> getActList(Active reqParam);
	
	List<Active> checkActName(Active reqParam);

	int upAct(Active active);
    
}