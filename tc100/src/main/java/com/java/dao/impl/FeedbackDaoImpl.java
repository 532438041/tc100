package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.FeedbackDao;
import com.java.entity.Feedback;

@Repository
public class FeedbackDaoImpl extends BaseDaoImpl<Feedback>implements FeedbackDao {

	@Override
	public List<Feedback> getFbList(Feedback reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getFbList"), reqParam);
	}

}