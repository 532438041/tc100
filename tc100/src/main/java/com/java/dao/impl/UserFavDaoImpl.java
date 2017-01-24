package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserFavDao;
import com.java.dto.FavDto;
import com.java.entity.UserFav;

@Repository
public class UserFavDaoImpl extends BaseDaoImpl<UserFav>implements UserFavDao {

	@Override
	public List<FavDto> getFavList(String userId) {
		return this.getSqlSession().selectList(getStateMentName("getFavList"), userId);
	}

}