package com.java.service;

import java.util.List;

import com.java.entity.Area;

public interface AreaService {

	List<Area> getAreaByPid(String pid);

	List<Area> getAreaByName(String cityName);

}
