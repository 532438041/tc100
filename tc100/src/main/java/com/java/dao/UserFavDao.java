package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.FavDto;
import com.java.entity.UserFav;

public interface UserFavDao extends BaseDao<UserFav>{

	List<FavDto> getFavList(String userId);
    
}