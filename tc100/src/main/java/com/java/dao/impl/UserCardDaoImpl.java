package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserCardDao;
import com.java.entity.UserCard;

@Repository
public class UserCardDaoImpl extends BaseDaoImpl<UserCard>implements UserCardDao {

	@Override
	public List<UserCard> getCardList(String userId) {
		return this.getSqlSession().selectList(getStateMentName("getCardList"), userId);
	}

	@Override
	public int useCard(String cardId, String userId) {
		this.getSqlSession().update(getStateMentName("unUseCard"), userId);
		return this.getSqlSession().update(getStateMentName("useCard"), cardId);
	}

}