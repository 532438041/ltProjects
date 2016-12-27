package com.java.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.ToolsUtil;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/adminLogin")
	public BaseResult AdminLogin(@RequestBody BaseParam<User> baseParam, HttpServletResponse response) {
		User user = userService.checkLogin(baseParam.getParam().getUserName());
		BaseResult baseResult = new BaseResult();
		if (ToolsUtil.isNotNull(user)) {
			if (!baseParam.getParam().getUserPwd().equals(user.getUserPwd())) {
				// 记录密码错误次数

				return baseResult.failed(-1, "用户名或密码错误！");
			}
			if (!user.getUserType().equals("0")) {
				return baseResult.failed(-2, "该用户不能登录本站点！");
			}
			if (user.getState().equals("2")) {
				return baseResult.failed(-3, "该用户已被禁用，请联系管理员！");
			}
			if (user.getState().equals("0")) {
				return baseResult.failed(-4, "用户名不存在！");
			}
		} else {
			return baseResult.failed(0, "用户名不存在！");
		}

		// 记录登录状态

		// 保存登录信息
		ToolsUtil.setCookie(response, "userId", user.getId());
		ToolsUtil.setCookie(response, "displayName", user.getDisplayName());

		return baseResult.success(1, "登录成功！");
	}

	@RequestMapping(value = "/login")
	public BaseResult login(@RequestBody BaseParam<User> baseParam, HttpServletResponse response) {
		User user = userService.checkLogin(baseParam.getParam().getUserName());
		BaseResult baseResult = new BaseResult();
		if (ToolsUtil.isNotNull(user)) {
			if (!baseParam.getParam().getUserPwd().equals(user.getUserPwd())) {
				// 记录密码错误次数

				return baseResult.failed(-1, "用户名或密码错误！");
			}
			if (!user.getUserType().equals("1")) {
				return baseResult.failed(-2, "该用户不能登录本站点！");
			}
			if (user.getState().equals("2")) {
				return baseResult.failed(-3, "该用户已被禁用，请联系管理员！");
			}
			if (user.getState().equals("0")) {
				return baseResult.failed(-4, "用户名不存在！");
			}
		} else {
			return baseResult.failed(0, "用户名不存在！");
		}

		// 记录登录状态

		// 保存登录信息
		ToolsUtil.setCookie(response, "userId", user.getId());
		ToolsUtil.setCookie(response, "displayName", user.getDisplayName());

		return baseResult.success(1, "登录成功！");
	}

}
