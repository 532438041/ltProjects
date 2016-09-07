package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.User;

public interface UserService extends BaseService<User>{

	int checkLogin(String userName, String userPwd);

	PageResult<User> getUserList(PageParam<User> pageParam);
	
}
