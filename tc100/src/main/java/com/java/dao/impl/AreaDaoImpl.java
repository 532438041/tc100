package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.AreaDao;
import com.java.entity.Area;

@Repository
public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao {

	@Override
	public List<Area> getAreaByPid(String pid) {
		return this.getSqlSession().selectList(getStateMentName("getAreaByPid"), pid);
	}

	@Override
	public List<Area> getAreaByName(String cityName) {
		return this.getSqlSession().selectList(getStateMentName("getAreaByName"), cityName);
	}

}
