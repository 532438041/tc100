package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Feedback;

public interface FeedbackDao extends BaseDao<Feedback>{

	List<Feedback> getFbList(Feedback reqParam);
    
}