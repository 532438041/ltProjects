package com.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void checkLogin() {
		String userName = "111";
		String userPwd = "111";
		int result = userService.checkLogin(userName, userPwd);
		System.out.println("result:" + result);
	}

}
