package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

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

	@RequestMapping(value = "/user/saveUser")
	public BaseResult saveUser(@RequestBody BaseParam<User> baseParam) {
		int status = 0;
		if (ToolsUtil.isNull(baseParam.getParam().getId())) {
			// 添加用户
			User user = baseParam.getParam();
			user.setId(ToolsUtil.getUUID());
			user.setCreateTime(new Date());
			status = userService.insert(user);
		} else {
			// 修改用户
			User user = baseParam.getParam();
			user.setUpdateTime(new Date());
			status = userService.updateByPrimaryKey(user);
		}
		return new BaseResult().success(status, "");
	}

	@RequestMapping(value = "/user/deleteUser")
	public BaseResult deleteUser(@RequestParam String id) {
		int status = userService.deleteByPrimaryKey(id);
		return new BaseResult().success(status, "");
	}

	@RequestMapping(value = "/user/getUserById")
	public BaseResult getUserById(@RequestParam String id) {
		User user = userService.selectByPrimaryKey(id);
		return new BaseResult().success(user);
	}

}
