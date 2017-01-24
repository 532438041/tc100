package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.entity.UserCard;

public interface UserCardService extends BaseService<UserCard> {

	List<UserCard> getCardList(String userId);

}