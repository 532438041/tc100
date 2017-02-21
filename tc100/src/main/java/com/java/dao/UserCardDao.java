package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.UserCard;

public interface UserCardDao extends BaseDao<UserCard> {

	List<UserCard> getCardList(String userId);

	int useCard(String cardId, String userId);

}