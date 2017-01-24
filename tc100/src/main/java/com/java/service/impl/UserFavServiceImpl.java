package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.UserFavDao;
import com.java.dto.FavDto;
import com.java.entity.UserFav;
import com.java.service.UserFavService;

@Service
public class UserFavServiceImpl extends BaseServiceImpl<UserFav>implements UserFavService {

	@Autowired
	private UserFavDao userFavDao;

	@Override
	public List<FavDto> getFavList(String userId) {
		return userFavDao.getFavList(userId);
	}

}