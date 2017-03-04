package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AreaDao;
import com.java.entity.Area;
import com.java.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaByPid(String pid) {
		return areaDao.getAreaByPid(pid);
	}

	@Override
	public List<Area> getAreaByName(String cityName) {
		return areaDao.getAreaByName(cityName);
	}
	
	

}
