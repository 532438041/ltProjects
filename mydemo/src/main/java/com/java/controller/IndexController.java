package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.User;
import com.java.service.UserService;

@RestController
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public BaseResult login(@RequestBody BaseParam<User> baseParam) {
		String userName = baseParam.getParam().getUserName();
		String userPwd = baseParam.getParam().getUserPwd();
		int count = userService.checkLogin(userName, userPwd);
		if (count > 0) {
			return new BaseResult().success(1, "登录成功！");
		} else {
			return new BaseResult().success(0, "用户名或密码错误！");
		}
	}

	@RequestMapping(value = "/user/getUserList")
	public BaseResult getUserList(@RequestBody PageParam<User> pageParam) {
		PageResult<User> list = userService.getUserList(pageParam);
		return new BaseResult().success(list);
	}

}
