package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.User;

public interface UserService extends BaseService<User>{

	User checkLogin(String userName);

	PageResult<User> getUserList(PageParam<User> pageParam);

	String getUserRoleName(String userId);

	int checkRegister(User user);
	
}
