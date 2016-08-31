package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PagedResult;
import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.utils.PageUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<User>implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int checkLogin(String userName, String userPwd) {
		return userDao.checkLogin(userName, userPwd);
	}

	@Override
	public PagedResult<User> getUserList(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return PageUtil.toPagedResult(userDao.getUserList());
	}

}
