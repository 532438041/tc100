package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.UserCardDao;
import com.java.entity.UserCard;
import com.java.service.UserCardService;

@Service
public class UserCardServiceImpl extends BaseServiceImpl<UserCard>implements UserCardService {

	@Autowired
	private UserCardDao userCardDao;

	@Override
	public List<UserCard> getCardList(String userId) {
		return userCardDao.getCardList(userId);
	}

	@Override
	public int useCard(String cardId, String userId) {
		return userCardDao.useCard(cardId, userId);
	}

}