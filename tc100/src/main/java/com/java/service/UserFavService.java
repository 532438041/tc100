package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.dto.FavDto;
import com.java.entity.UserFav;

public interface UserFavService extends BaseService<UserFav>{

	List<FavDto> getFavList(String userId);
    
}