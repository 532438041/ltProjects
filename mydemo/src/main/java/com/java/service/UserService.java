package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PagedResult;
import com.java.entity.User;

public interface UserService extends BaseService<User>{

	int checkLogin(String userName, String userPwd);

	PagedResult<User> getUserList(Integer pageNo, Integer pageSize);
	
}
