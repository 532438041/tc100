package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Active;

public interface ActiveDao extends BaseDao<Active>{

	List<Active> getActiveList(Active reqParam);

	List<Active> getMyActList(String userId, String actType);

	int addViewCount(String actId);

	void operateAct(String actId, int amount);
    
}