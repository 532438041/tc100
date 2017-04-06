package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Person;

public interface PersonService extends BaseService<Person> {

	PageResult<Person> getPersonList(PageParam<Person> pageParam);

}