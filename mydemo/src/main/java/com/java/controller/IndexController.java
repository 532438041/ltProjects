package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.common.entity.PagedResult;
import com.java.entity.User;
import com.java.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index(Model model, RedirectAttributes redirectAttributes, User user) {
		String userName = user.getUserName();
		String userPwd = user.getUserPwd();
		int count = userService.checkLogin(userName, userPwd);
		String msg = "用户名或密码错误！";
		if (count > 0) {
			msg = "登录成功！";
			redirectAttributes.addFlashAttribute("msg", msg);
			return "redirect:/user/list";
		} else {
			model.addAttribute("msg", msg);
			return "index";
		}
	}

	@RequestMapping(value = "/user/list")
	public String list(Model model) {
		return "user/list";
	}

	@RequestMapping(value = "/user/getUserList")
	@ResponseBody
	public String getUserList(Integer pageNo, Integer pageSize) {
		PagedResult<User> list = userService.getUserList(pageNo, pageSize);
		return JSONObject.fromObject(list).toString();
	}
}
