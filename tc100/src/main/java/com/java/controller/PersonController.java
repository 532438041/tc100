package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Person;
import com.java.service.PersonService;
import com.java.utils.ToolsUtil;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/getPersonList")
	public BaseResult getPersonList(@RequestBody PageParam<Person> pageParam) {
		return new BaseResult().success(personService.getPersonList(pageParam));
	}

	@RequestMapping(value = "/getPerson")
	public BaseResult getPerson(String personId) {
		return new BaseResult().success(personService.selectByPrimaryKey(personId));
	}

	@RequestMapping(value = "/savePerson")
	public BaseResult savePerson(@RequestBody BaseParam<Person> baseParam) {
		baseParam.getParam().setUpdateTime(new Date());
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setCreateTime(new Date());
			return new BaseResult().success(personService.insert(baseParam.getParam()), "操作成功！");
		} else {
			return new BaseResult().success(personService.updateByPrimaryKeySelective(baseParam.getParam()), "操作成功！");
		}
	}

}
