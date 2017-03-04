package com.java.dao;

import java.util.List;

import com.java.entity.Area;

public interface AreaDao {

	List<Area> getAreaByPid(String pid);

	List<Area> getAreaByName(String cityName);
    
}