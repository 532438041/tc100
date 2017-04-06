package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.PersonDao;
import com.java.entity.Person;
import com.java.service.PersonService;
import com.java.utils.PageUtil;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person>implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public PageResult<Person> getPersonList(PageParam<Person> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(personDao.getPersonList(pageParam.getReqParam()));
	}

}