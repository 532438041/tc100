package com.java.base.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.base.BaseDao;

@Repository
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public int deleteByPrimaryKey(String key) {
		return this.getSqlSession().delete(getStateMentName("deleteByPrimaryKey"), key);
	}

	public String getStateMentName(String methodName) {
		String clazzName = this.getClass().getName();
		return clazzName + "." + methodName;
	}

	public int insert(T t) {
		return this.getSqlSession().insert(getStateMentName("insert"), t);
	}

	public int insertSelective(T t) {
		return this.getSqlSession().insert(getStateMentName("insertSelective"), t);
	}

	@SuppressWarnings("unchecked")
	public T selectByPrimaryKey(String key) {
		return (T) this.getSqlSession().selectOne(getStateMentName("selectByPrimaryKey"), key);
	}

	public int updateByPrimaryKeySelective(T t) {
		return this.getSqlSession().update(getStateMentName("updateByPrimaryKeySelective"), t);
	}

	public int updateByPrimaryKey(T t) {
		return this.getSqlSession().update(getStateMentName("updateByPrimaryKey"), t);
	}

}
