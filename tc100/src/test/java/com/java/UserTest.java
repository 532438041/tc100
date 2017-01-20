package com.java;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void checkLogin() {
		User user = new User();
		user.setId(ToolsUtil.getUUID());
		user.setUserName("test1");
		user.setUserPwd("111");
		user.setCreateTime(new Date());
		int result = userService.insert(user);
		System.out.println("result:" + result);
	}

}
