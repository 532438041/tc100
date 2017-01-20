package com.java.base.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.base.BaseRelDao;

@Repository
public class BaseRelDaoImpl extends SqlSessionDaoSupport implements BaseRelDao {

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public String getStateMentName(String methodName) {
		String clazzName = this.getClass().getName();
		return clazzName + "." + methodName;
	}

	@Override
	public int deleteByKeys(Map<String, Long> map) {
		return this.getSqlSession().delete(getStateMentName("deleteByKeys"), map);
	}

	@Override
	public int insert(Map<String, Long> map) {
		return this.getSqlSession().insert(getStateMentName("insert"), map);
	}

	@Override
	public int deleteByKey(String labName, Long id) {
		Map<String, Long> map = new HashMap<>();
		map.put(labName, id);
		return this.getSqlSession().delete(getStateMentName("deleteByKey"), map);
	}

}
